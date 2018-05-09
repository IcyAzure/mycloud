/*
 *
 * Copyright (C) 1999-2014 IFLYTEK Inc.All Rights Reserved.
 *
 * FileName：mycloud
 *
 * Description：
 *
 * History：
 * Version   Author      Date            Operation
 * 1.0	     admin    2018/5/913:42	  Create
 */
package com.luyuheng.mycloud.test;

import java.io.*;

public class Resource {

    public void getResource() throws IOException{
        InputStream is = this.getClass().getResourceAsStream("pom.xml");
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String s="";
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
}
