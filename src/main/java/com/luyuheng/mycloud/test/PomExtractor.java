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
 * 1.0	     admin    2018/5/914:00	  Create
 */
package com.luyuheng.mycloud.test;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 读取zip文件,jar类型文件
 */
public class PomExtractor {

    public String analyzeJarFile(File file){
        if (!file.exists()) return "file not found";
        try(ZipFile zipFile = new ZipFile(file)){
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();
                if (entry.getName().endsWith("MANIFEST.MF")){
                    Scanner scanner = new Scanner(zipFile.getInputStream(entry), "US-ASCII");
                    while (scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        if (line.contains("Build-Number")){
                            return line;
                        }
                    }
                }
            }
        }catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return "";
    }
}
