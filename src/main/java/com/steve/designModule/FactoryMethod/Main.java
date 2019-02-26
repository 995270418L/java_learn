package com.steve.designModule.FactoryMethod;
import com.steve.designModule.FactoryMethod.Abstract.ImageFactory;
import com.steve.designModule.FactoryMethod.Classes.JpgFactory;
import com.steve.designModule.FactoryMethod.Classes.JpgImage;

import java.io.IOException;

/**
 * Created by liu on 3/25/17.
 */
public class Main {

    public static void main(String... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ImageFactory ifac = null;
        JpgImage ji = null;
        ifac = new JpgFactory();
        ji = (JpgImage) ifac.format();
        ji.reader();
    }
}
