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
 * 1.0	     admin    2018/5/913:45	  Create
 */
package com.luyuheng.mycloud.test;

import java.io.File;

public class Test {

    public static void main(String[] args){
        PomExtractor pomExtractor = new PomExtractor();
        String str = pomExtractor.analyzeJarFile(new File("C:\\Users\\admin\\Desktop\\GYJ20\\nonparty-platform-server.jar"));
        int startIndex = str.indexOf(":");
        System.out.println(str.substring(startIndex+1).trim());
    }
}
