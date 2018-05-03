package com.luyuheng.mycloud.service.impl;

import com.luyuheng.mycloud.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Author:luyuheng
 * @Date:2018/4/27 15 03
 * @Description
 */
@Service
public class HelloServiceImpl implements HelloService {


    private Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Value("${mypath}")
    private String templateDownloadUrl;



    @Override
    public byte[] templateDownload() throws IOException {
        byte[] body = null;
        File file = new File(templateDownloadUrl);
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        return body;
    }

}
