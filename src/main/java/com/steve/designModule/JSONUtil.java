package com.steve.designModule;

import com.alibaba.fastjson.JSONReader;

import java.io.*;

/**
 * Created by liu on 3/25/17.
 */
public class JSONUtil {
    public static Object getBean() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        JSONReader reader = new JSONReader(new FileReader("/home/liu/IdeaProjects/JavaAlg/src/com/floder/designModule/data.json"));
        reader.startObject();
        String value = "";
        while(reader.hasNext()){
            reader.readString();
            value = reader.readObject(String.class);
        }
        reader.endObject();
        reader.close();
        Class c =Class.forName(value);
        Object o = c.newInstance();
        return o;
    }
    public static void main(String... args) throws IOException {

    }
}
