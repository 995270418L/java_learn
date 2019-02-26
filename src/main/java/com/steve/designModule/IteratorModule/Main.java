package com.steve.designModule.IteratorModule;

import com.steve.designModule.IteratorModule.Classes.ClassInSchool;
import com.steve.designModule.IteratorModule.Classes.Student;

import java.util.ArrayList;

/**
 * Created by liu on 4/4/17.
 * 迭代期模式，这次的练习没什么难度
 * 在Sunny软件公司开发的某教务管理系统中,一个班级(Class	in	School)包含多个学生
 * (Student),使用Java内置迭代器实现对学生信息的遍历,要求按学生年龄由大到小的次序
 * 输出学生信息。
 */
public class Main {

    public static void main(String... args){
        ArrayList<Student> list = new ArrayList();
        Student stu1 = new Student("liu",21,1403040229);
        Student stu2 = new Student("haha",20,1403040230);
        Student stu3 = new Student("luo",23,1403040222);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ClassInSchool cis = new ClassInSchool(list);
        int size = list.size();
        for(int i=0;i<size;i++){
            cis.getNextItem();
        }
    }
}
