package com.steve.cow_guest.classes.c3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: steve
 * @Date: Created in 16:16 2018/6/16
 * @Description: 比较器的使用
 * @Modified By:
 */
public class Comparator {

    static class Student{
        String name;
        int age;
        int id;
        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdBigTree implements java.util.Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }

    public static void main(String[] args) {
        Student s3 = new Student("steve",1,13);
        Student s1 = new Student("steve2",2,20);
        Student s2 = new Student("steve3",3,22);
        Student[] ss = new Student[]{s1,s2,s3};
//        Arrays.sort(ss,new IdBigTree());
        // 优先队列即堆结构。，如果没传入Compartor的实现类，默认是按照对象的内存地址建堆的。
        PriorityQueue<Student> bigTree = new PriorityQueue<>( (o1,o2) -> o2.id-o1.id );
        bigTree.add(s1);
        bigTree.add(s3);
        bigTree.add(s2);
        while(!bigTree.isEmpty()){
            Student s = bigTree.poll();
            System.out.println("name :" + s.name + "\t id:" + s.id + "\t age: " + s.age);
        }
//        printStudents(ss);
    }

    private static void printStudents(Student[] ss) {
        for(Student s : ss){
            System.out.println("name :" + s.name + "\t id:" + s.id + "\t age: " + s.age);
        }
    }
}
