package demo;//package com.dongtai.demo; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DynamicCompileTestb {
    public static void main(String[] args) throws IOException{
        // 1.创建�?要动态编译的代码字符�?
        String nr = "\r\n"; //回车
        String source = "package temp.com; " + nr +
                " public class  Hello{" + nr + 
                    " public static void main (String[] args){" + nr + 
                        " System.out.println(\"HelloWorld! "+System.currentTimeMillis()+"\");" + nr +
                    " }" + nr +
                " }";
        // 2.将欲动�?�编译的代码写入文件�? 1.创建临时目录 2.写入临时文件目录
        System.out.println(System.getProperty("user.dir") + "/temp");
        File dir = new File(System.getProperty("user.dir") + "/temp"); //临时目录
        // 如果 \temp 不存�? 就创�?
        if (!dir.exists()) {
            dir.mkdir();
        }
        FileWriter writer = new FileWriter(new File(dir,"Hello.java"));
        writer.write(source);
        writer.flush();
        writer.close();
        
        // 3.取得当前系统的编译器
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        // 4.获取�?个文件管理器
        StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        // 5.文件管理器根与文件连接起�?
        Iterable it = javaFileManager.getJavaFileObjects(new File(dir,"Hello.java"));
        // 6.创建编译任务
        CompilationTask task = javaCompiler.getTask(null, javaFileManager, null, Arrays.asList("-d", "./temp"), null, it);
        // 7.执行编译
        task.call();
        javaFileManager.close();
        
        // 8.运行程序
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp ./temp temp/com/Hello");
        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info  = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
            
        }
    }
}