/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: BinarySearchTree.java 
 * @Prject: TestForJava
 * @Package: floder.com.alg4 
 * @Description: TODO
 * @author: liu   
 * @date: Oct 8, 2016 10:46:33 PM 
 * @version: V1.0   
 */
package com.steve.algorithmbook.alg4;

/** 
 * @ClassName: BinarySearchTree 
 * @Description: 二叉查找树
 * @author: liu
 * @date: Oct 8, 2016 10:46:33 PM  
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	private static class BinaryNode<T>{
		BinaryNode leftNode;
		BinaryNode rightNode;
		T elements;
		/** 
		 * @Title:BinarySearchTree.BinaryNode
		 * @Description:TODO  
		 */
		 BinaryNode(T element) {
			this(element,null,null);
		}
		 BinaryNode(T elements,BinaryNode left,BinaryNode right){
			this.elements = elements;
			this.leftNode = left;
			this.rightNode = right;
		}
	}
	
	private BinaryNode<T> root ; 
	
	public BinarySearchTree(){
		root = null;
	}
	
	//判断二叉查找树是否为空
	public boolean isEmpty(){
		return root == null;
	}
	//判断二叉查找树是否存在某个元素
	public boolean contains(T t){
		return contains(t,root);
	}
	public boolean contains(T t,BinaryNode<T> root){
		if(root == null)
			return false;
		int a = root.elements.compareTo(t);
		if(a>0){
			//比根节点小，从左边找
			return contains(t,root.leftNode);
		}else if(a<0){
			return contains(t,root.rightNode);
		}else{
			return true;
		}
	}
	//找二叉查找树的最小值
	public T findMin(){
		if(isEmpty())
			throw new NullPointerException();
		return findMin(root).elements;
	}
	@SuppressWarnings("unchecked")
	public BinaryNode<T> findMin(BinaryNode<T> root){
		if(root == null)
			return null;
		if(root.leftNode == null){
			return root;
		}else{
			return findMin(root.leftNode);
		}
    }
	//找最大值
	public T findMax(){
		if(isEmpty())
			throw new NullPointerException();
		return findMax(root).elements;
	}
	@SuppressWarnings("unchecked")
	public BinaryNode<T> findMax(BinaryNode<T> root){
		if(root == null)
			return null;
		if(root.rightNode == null){
			return root;
		}else{
			return findMax(root.rightNode);
		}
	}
	
	public void insert(T t){
		root = insert(t,root);
	}
	
	public BinaryNode<T> insert(T t,BinaryNode<T> root){
		//这是是用的递归，还有一种方法是通过调用contains()方法
		if(root == null)
			return new BinaryNode<T>(t);
		int a = root.elements.compareTo(t);
		if(a > 0){
			root.leftNode = insert(t,root.leftNode);
		}else if(a < 0 ){
			root.rightNode = insert(t, root.rightNode);
		}else{
			
		}
		return root;	
		
	}
	public boolean remove(T t){
		//如果不存在
		if(!contains(t))
			return false;
		remove(t,root);
		return true;
	}
	public BinaryNode<T> remove(T t,BinaryNode<T> root){
		if(root == null){
			return root;
		}
		int a = root.elements.compareTo(t);
		if(a > 0){
			//如果删除的节点位于根节点左边(继续寻找)
			 root.leftNode = remove(t,root.leftNode);
		}else if(a < 0){
			//如果删除的节点位于根节点的右边(继续寻找)
			root.rightNode = remove(t, root.rightNode);
		}else if(root.leftNode != null && root.rightNode != null){
			//如果该节点有两个节点  (找到了)
			//将右边最小的值去替代将要删除的值
			root.elements = (T) findMin(root.rightNode).elements;
			//继续递归删除右边最小的值并将上一节点的右节点设置为null
			root.rightNode = remove(root.elements, root.rightNode);
		}else
			//如果该节点和查找的节点大小相等　(找到了)
			//判断左节点是否为空（一般都是右子节点为空才调用到这里）　
			root = (root.leftNode != null) ? root.leftNode : root.rightNode;
		return root;
	}
	public BinaryNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
}
