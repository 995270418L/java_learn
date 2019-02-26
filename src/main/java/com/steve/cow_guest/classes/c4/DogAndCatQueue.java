package com.steve.cow_guest.classes.c4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: steve
 * @Date: Created in 18:41 2018/6/17
 * @Description: 猫狗队列问题，给定数据类型，要求自定义一个结构，要求输出猫的时候，必须按照队列的特性输出猫的第一个，狗也一样，
 *                pollAll方法输出所有宠物里面最早的一个。
 * @Modified By:
 */
public class DogAndCatQueue {

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    public static class Dog extends Pet{
        private String name;
        public Dog(String name) {
            super("Dog");
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Cat extends Pet{
        private String name;
        public Cat(String name) {
            super("Cat");
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // 自定义一个数据结构
    public static class PetEnter{
        private Pet pet;
        private long count;

        public PetEnter(Pet pet,long count){
            this.pet = pet;
            this.count= count;
        }

        public long getCount() {
            return count;
        }

        public Pet getPet() {
            return pet;
        }
    }

    public static class DogCat{
        private Queue<PetEnter> dogs = new LinkedList<>();
        private Queue<PetEnter> cats = new LinkedList<>();
        // 线程安全的
        private AtomicLong count = new AtomicLong(0);

        public void add(Pet pet){
            if(pet.getType().equals("Dog")){
                dogs.add(new PetEnter(pet,count.getAndIncrement()));
            }else if(pet.getType().equals("Cat")){
                cats.add(new PetEnter(pet,count.getAndIncrement()));
            }else{
                throw new IllegalStateException("非猫狗类型的宠物");
            }
        }

        // 弹出队列中第一条狗
        public Dog pollDog(){
            if(!dogs.isEmpty()){
                return (Dog) dogs.poll().getPet();
            }else{
                throw new IllegalStateException("队列中没狗了");
            }
        }

        // 弹出队列中第一条猫
        public Cat pollCat(){
            if(!cats.isEmpty()){
                return (Cat) cats.poll().getPet();
            }else{
                throw new IllegalStateException("队列中没猫了");
            }
        }

        public Pet pollAll(){
            if(isEmpty()){
                throw new IllegalStateException("队列中没宠物了");
            }else if(dogs.isEmpty() && !cats.isEmpty()){
                return cats.poll().getPet();
            }else if(cats.isEmpty() && !dogs.isEmpty()){
                return dogs.poll().getPet();
            }else{
                if(dogs.peek().getCount() < cats.peek().getCount()){
                    return dogs.poll().getPet();
                }else{
                    return cats.poll().getPet();
                }
            }
        }

        public boolean isEmpty(){
            if(dogs.isEmpty() && cats.isEmpty()){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Pet p1 = new Dog("p1");
        Pet p2 = new Cat("p2");
        Pet p3 = new Cat("p3");
        Pet p4 = new Cat("p4");
        Pet p5 = new Dog("p5");
        DogCat dc = new DogCat();
        dc.add(p1);
        dc.add(p2);
        dc.add(p3);
        dc.add(p4);
        dc.add(p5);
        System.out.println(dc.pollDog().getName());
        System.out.println(dc.pollDog().getName());
        System.out.println(dc.pollCat().getName());
        System.out.println(dc.pollAll().getType());
    }
}
