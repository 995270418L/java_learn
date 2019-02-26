package com.steve.algorithmbook.alg5;

/**
 * Created by liu on 10/30/16.
 * 新建散列的对象
 */
public class Elements {

    private String name;

    private int age;

    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //重写hashCode方法　　为什么需要重写toString()方法？
    //协议规定相同的对象必须有相同的hashCode。就是一致性吧，重写是为了比较的是对象的value而不是Object的比较地址，
    // 而判断相等需要hashCode和对象的值保持一致性。
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elements elements = (Elements) o;

        if (age != elements.age) return false;
        if (!name.equals(elements.name)) return false;
        return gender != null ? gender.equals(elements.gender) : elements.gender == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}