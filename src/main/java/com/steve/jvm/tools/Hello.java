package com.steve.jvm.tools;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hello extends FileInputStream implements Runnable,ActionListener{

    private String name;

    public Hello(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

