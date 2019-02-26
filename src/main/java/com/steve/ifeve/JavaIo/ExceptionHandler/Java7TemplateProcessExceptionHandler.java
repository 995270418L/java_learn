package com.steve.ifeve.JavaIo.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liu on 6/19/17.
 * java7+以上版本可以通过Try-With-Resource来自动关闭
 *
 */
public class Java7TemplateProcessExceptionHandler {

    public void process(String filename){
        
        try(InputStream inputStream = new FileInputStream(filename)){
            byte[] bytes = new byte[1024];
            inputStream.read(bytes); // 应该多使用缓存式写入，读取的话容易造成结尾重复读取.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
