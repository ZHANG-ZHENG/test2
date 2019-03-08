package demo;//package com.dongtai.demo; 

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 

import javax.tools.JavaCompiler; 
import javax.tools.ToolProvider; 
//http://www.cnblogs.com/snake-hand/p/3159694.html
public class DynamicCompileTesta { 
    public static void main(String[] args) throws IOException { 
        // 编译程序 
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler(); 
        int result = javaCompiler.run(null, null, null, "-d","./temp/","./temp/com/Hello.java"); 
        System.out.println( result == 0 ? "恭喜编译成功" : "对不起编译失�?"); 
         
        // 运行程序 
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