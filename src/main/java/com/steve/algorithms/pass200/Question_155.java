package com.steve.algorithms.pass200;

import java.util.Stack;

/**
 *
 * 简单：
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class Question_155 {

    private Stack<Integer> stack;
    private int min;

    public Question_155() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min) {
            stack.push(min); // 0 1 0 getMin pop getMin
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if(val == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    

    public static void main(String[] args) {
        Question_155 question = new Question_155();

    }

}
