package com.steve.ifeve.multipartline.chapter6;

import com.sun.scenario.effect.ImageData;

public class ImageInfo{
    private int size;   //image size
    private String name;  //image name
    private String url;   //iamge url

    ImageInfo(int size,String name,String url){
        this.size = size ;
        this.name = name ;
        this.url = url ;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static ImageData downloadImage(){
        return null;

    }
}