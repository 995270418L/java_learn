package com.steve.designModule.PrototypeModule.Classes;

import java.io.*;

/**
 * Created by liu on 3/26/17.
 * 深复制需要继承Serialize接口
 * java潜复制需要继承Cloneable接口
 */
public class Customer implements Serializable{

    private Address address;
    private String username;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //潜复制
//    public Customer clone(){
//        Customer obj = null;
//        try{
//            obj = (Customer) super.clone();
//        }catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }

    //深复制
    public Customer deepClone() throws IOException, ClassNotFoundException {
        Customer obj = null;
        //将对象写出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //将对象写入新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Customer) ois.readObject();
    }
}
