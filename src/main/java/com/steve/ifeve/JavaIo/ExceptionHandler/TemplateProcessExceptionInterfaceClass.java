package com.steve.ifeve.JavaIo.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liu on 6/19/17.
 * 使用的话就是:
 * new TemplateProcessExceptionInterfaceClass().process("/home/liu/....",new TemplateProcessExceptionInterface(){
 *     public void doProcess(InputStream input){
 *         // deal with input method here.
 *     }
 * })
 */
public class TemplateProcessExceptionInterfaceClass {

    public void process(String filename, TemplateProcessExceptionInterface process){
        //　捕捉IOException　不让其往上传递
        IOException processException = null;
        InputStream stream = null;
        try{
            stream = new FileInputStream(filename);
            process.doProcess(stream);
        } catch (FileNotFoundException e) {
            processException = e;
        }finally {
            try{
                stream.close();
            } catch (IOException e) {
                if(processException != null){
                    // throw processException
                }else {
                    // throw　自定义异常
                }
            }
            if(processException != null){
                // throw processException
            }
        }
    }

}
