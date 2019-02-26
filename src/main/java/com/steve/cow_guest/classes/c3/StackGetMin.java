package com.steve.cow_guest.classes.c3;

import java.util.Stack;

/**
 * @Author: steve
 * @Date: Created in 18:52 2018/6/16
 * @Description: 构建一个栈，要求找寻栈中的最小值，pop，push，getMin操作用时都为O(1)
 * 解析： 借用一个栈min保存每次存入的最小值，当当前存入的值比min栈栈顶还要小，就把该值放入min栈栈顶，否则重复放入min栈栈顶值。取出的时候一同取出即可。
 * @Modified By:
 */
public class StackGetMin {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public Integer peek(){
        return stackData.peek();
    }

    public Integer pop(){
        stackMin.pop();
        return stackData.pop();
    }

    public void push(Integer value){
        if(stackMin.isEmpty()){
            stackMin.push(value);
        }else{
            int newVal = stackMin.peek();
            stackMin.push(newVal > value ? value : newVal);
        }
        stackData.push(value);
    }

    public Integer getMin(){
        return stackMin.peek();
    }

}