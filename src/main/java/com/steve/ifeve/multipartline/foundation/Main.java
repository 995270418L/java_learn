package com.steve.ifeve.multipartline.foundation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liu on 5/4/17.
 */
public class Main {

    public static void main(String... args){
        Thread thread1 = new Thread(new NewRunable());
        Thread thread2 = new NewThread();
        thread1.start();
        thread2.start();
    }

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal(){
        public Connection initiavalue() throws SQLException {
            return DriverManager.getConnection("sss");
        }
    };

    public static Connection getConnection(){
        return connectionThreadLocal.get();
    }

    private final Set<String> names = new HashSet();

    public Main(){
        names.add("liu");
        names.add("floder");
        names.add("curly");
    }

}