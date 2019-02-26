package com.steve.designModule.IteratorModule.Classes;

import java.util.*;

/**
 * Created by liu on 4/4/17.
 * 班级
 */
public class ClassInSchool {

    private ArrayList<Student> list ;

    public ClassInSchool(ArrayList<Student> list){
        this.list = list;
    }

    public void addStudent(Student s){
        list.add(s);
    }

    public void removeStudent(Student s){
        list.remove(s);
    }

    public void getNextItem(){
        if(list.size() != 0) {
            Student max = list.get(0);
            for (int i = 1; i < list.size() ; i++) {
                if (list.get(i).getAge() > max.getAge()) {
                    max = list.get(i);
                }
            }
            System.out.println(max.toString());
            list.remove(max);
        }
    }
}
