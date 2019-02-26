package com.steve.designModule.FlyWeightModule;

import com.steve.designModule.FlyWeightModule.Abstractes.FlyWeight;
import com.steve.designModule.FlyWeightModule.Classes.FlyWeightFactory;
import com.steve.designModule.FlyWeightModule.Classes.Location;
import com.steve.designModule.FlyWeightModule.Classes.Size;

/**
 * Created by liu on 3/31/17.
 * 亨元模式的应用
 * Sunny软件公司欲开发一个多功能文档编辑器,在文本文档中可以插入图片、动画、视频
 * 等多媒体资料,为了节约系统资源,相同的图片、动画和视频在同一个文档中只需保存
 * 一份,但是可以多次重复出现,而且它们每次出现时位置和大小均可不同。试使用享元
 * 模式设计该文档编辑器。
 */
public class Main {

    public static void main(String... args){
        FlyWeightFactory factory;
        FlyWeight text,text2,video,pic;

        factory = FlyWeightFactory.getInstance();
        text = factory.getValue("t");
        text2 = factory.getValue("t");
        video = factory.getValue("v");
        pic = factory.getValue("p");
        System.out.println("判断对象是否为单例: " + (text==text2));
        text.display(new Location(1,3),new Size(2));
        text2.display(new Location(2,4),new Size(5));
        pic.display(new Location(1,3),new Size(10));
        video.display(new Location(1,3),new Size(20));
    }
}
