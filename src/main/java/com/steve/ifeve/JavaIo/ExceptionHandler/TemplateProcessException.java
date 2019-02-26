package com.steve.ifeve.JavaIo.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liu on 6/19/17.
 * 抽象类来解决javaIO类处理异常的问题，优点:将重复性代码提炼出来. 缺点:不便于阅读
 *
 * 调用的时候就是
 * new TemplateProcessException(){
 *     public void doProcess(InputStream input){
 *         // deal with input
 *     }
 * }.process("/home/liu/Desktop/chinese.txt");
 */
public abstract class TemplateProcessException {

    public void process(String filename){
        //　捕捉IOException　不让其往上传递
        IOException processException = null;
        InputStream stream = null;
        try{
            stream = new FileInputStream(filename);
            doProcess(stream);
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

    public abstract void doProcess(InputStream input);
}
