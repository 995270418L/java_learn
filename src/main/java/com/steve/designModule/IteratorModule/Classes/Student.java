package com.steve.designModule.IteratorModule.Classes;

/**
 * Created by liu on 4/4/17.
 */
public class Student {

    private String name;
    private int age;
    private int num;

    public Student(String name,int age,int num){
        this.name= name;
        this.age = age;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "name: " + this.name + " age: " + this.age + " number: " + this.num;
    }
}
