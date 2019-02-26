package com.steve.designModule.PrototypeModule;

import com.steve.designModule.PrototypeModule.Classes.PPR;
import com.steve.designModule.PrototypeModule.Classes.PrototypeManager;
import com.steve.designModule.PrototypeModule.Interfaces.OfficeDocument;

import java.io.IOException;

/**
 * Created by liu on 3/26/17.
 */
public class Main {

//    public static void main(String... args) throws IOException, ClassNotFoundException {
//        Customer cus = new Customer();
//        cus.setAddress(new Address());
//        Customer cus2 = cus.deepClone();
//        System.out.println("cus == cus2 ? " + (cus == cus2));
//        //潜复制
//        System.out.println("cus.address == cus2.address ? " + (cus.getAddress() == cus2.getAddress()));
//
//    }

    //用单例类管理对象的clone()
    public static void main(String... args){
        PrototypeManager pm = PrototypeManager.getInstance();
        OfficeDocument od = pm.getPrototype("FAR");
        od.display();
        pm.addPrototype("PPR",new PPR());
        pm.getPrototype("PPR").display();
    }
}
