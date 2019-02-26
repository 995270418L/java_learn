package com.steve.ifeve.Reflection.DynamicReflection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by liu on 6/27/17.
 * 自己实现一个简易的类加载器
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader classLoader){
        super(classLoader);
    }

    /**
     * 动态加载一个类首先需要获得一个ClassLoader,
     *  再调用loadClass方法才能实现动态加载
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!"Main".equals(name)){
            return super.loadClass(name);
        }
        try{
            // 这里导向的地址为class字节文件。
            String url = "file://" + "/home/liu/IdeaProjects/JavaAlg/src/Main.class";
            URL myUrl = new URL(url);
            URLConnection urlConnection = myUrl.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            // 以字节数组的形式
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int data = inputStream.read();
            while(data != -1){
                outputStream.write(data);
                data = inputStream.read();
            }
            inputStream.close();
            byte[] classData = outputStream.toByteArray();

            /**
             * 将一个byte[]转换成一个新的类的实例，在这个类使用之前它必须被连接(所有被加载的类都需要被链接)
             */
            return defineClass("Main",classData,0,classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
