package com.steve.cow_guest.common;

/**
 * @Author: steve
 * @Date: Created in 11:08 2018/2/26
 * @Description:
 * @Modified By:
 */
public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
