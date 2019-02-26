package com.steve.designModule.DecoratorModule;

import com.steve.designModule.DecoratorModule.Abstractes.Encrypt;
import com.steve.designModule.DecoratorModule.Classes.FirstEncrypt;
import com.steve.designModule.DecoratorModule.Classes.SecondEncrypt;
import com.steve.designModule.DecoratorModule.Classes.SourceEncrypt;
import com.steve.designModule.DecoratorModule.Classes.ThirdEncrypt;

/**
 * Created by liu on 3/30/17.
 * Sunny软件公司欲开发了一个数据加密模块,可以对字符串进行加密。最简单的加密算法
 *  通过对字母进行移位来实现,同时还提供了稍复杂的逆向输出加密,还提供了更为高级
 *  的求模加密。用户先使用最简单的加密算法对字符串进行加密,如果觉得还不够可以对
 *  加密之后的结果使用其他加密算法进行二次加密,当然也可以进行第三次加密。试使用
 *  装饰模式设计该多重加密系统
 */
public class Main {

    public static void main(String... args){
        Encrypt e0,e1,e2,e3;
        e0 = new SourceEncrypt();
        e1 = new FirstEncrypt(e0);
        e2 = new SecondEncrypt(e1);
        e3 = new ThirdEncrypt(e2);

        System.out.println(e1.encrypted("floder"));
    }

}
