package com.luyuheng.mycloud.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luyuheng.mycloud.pojo.Authority;
import com.luyuheng.mycloud.pojo.Equip;
import com.luyuheng.mycloud.pojo.ExcelResult;
import com.luyuheng.mycloud.pojo.Protoss;
import com.luyuheng.mycloud.service.HelloService;
import com.luyuheng.mycloud.utils.ExcelUtils;
import com.luyuheng.mycloud.utils.tree.AuthorityTreeNode;
import com.luyuheng.mycloud.utils.tree.AuthorityTreeNodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author:luyuheng
 * @Date:2018/4/25 22 11
 * @Description
 */
@RestController
@RequestMapping("/")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @Value("${myconfig}")
    private String[] array;

    @Value("${mypath}")
    private String mypath;

    @RequestMapping("/{word}")
    public String helloPath(@PathVariable("word") String str){
        return "Hello,"+str;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam Protoss protoss){
        return "protoss:"+ protoss;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Boolean str){
        log.info("str:" + str);
        ExcelUtils<Equip> excelUtils = new ExcelUtils<Equip>(Equip.class);
        File file = new File(mypath);
        if (file.exists() && file.isFile()) {
            ExcelResult<ArrayList<Equip>> excelResult = excelUtils.excelReader(file, array);
            log.info(excelResult.getMessage());
            for(Equip equip:excelResult.getData()){
                log.info(equip.toString());
            }
            return excelResult.getMessage();
        }else {
            log.info("文件不存在");
            return "文件不存在";
        }
    }

    @RequestMapping("/config")
    public String config(){
        return Arrays.toString(array);
    }

    @RequestMapping(value = "/config",method = RequestMethod.POST)
    public String configPost(){return "Post Method";}

    @RequestMapping(value = "/templateDownload",method = RequestMethod.GET)
    public ResponseEntity templateDownload(){
        String fileName = null;
        byte[] body = null;
        try{
            body = helloService.templateDownload();
            fileName = new String("批量导入模板.xlsx".getBytes("UTF-8"),"iso-8859-1");
        }catch (IOException e){
            log.info("模板下载出错========="+e);
            String errMsg = "模板文件损坏或已不存在，请联系管理员！";
            return new ResponseEntity<String>(errMsg,HttpStatus.OK);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers,HttpStatus.CREATED);
        return entity;
    }

    @RequestMapping(value = "/getAuthority",method = RequestMethod.GET)
    public String getAuthority(){
        JSONArray array = JSONObject.parseArray("[]");
        AuthorityTreeNodeBuilder builder = new AuthorityTreeNodeBuilder();
        AuthorityTreeNode root = builder.buildTree(array.toJavaList(Authority.class));
        return JSONObject.toJSONString(root);
    }
}
