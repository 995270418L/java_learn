/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: binarytree.java
 * @Prject: TestForJava
 * @Package: floder.com.alg4 
 * @Description: TODO
 * @author: liu   
 * @date: Oct 8, 2016 12:04:03 AM 
 * @version: V1.0   
 */
package com.steve.algorithmbook.alg4;

/** 
 * @ClassName: binarytree
 * @Description: 二叉树的java代码实现
 * @date: Oct 8, 2016 12:04:03 AM  
 */
public class BinaryTree {
	
	//树的深度
	private int depth;

	//根节点代表
	private Node root;
	
	//构建树的节点抽象基本类型
	static class Node{
		//节点数据
		Object element;
		//左儿子节点
		Node left;
		//右儿子节点
		Node right;
		public Node(Object element,Node left,Node right) {
			// TODO Auto-generated constructor stub
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	//初始化创造根节点
	public BinaryTree(Object element){
		root = new Node(element,null,null);
	}
	
	//创造左儿子节点 　传入上一个节点　和下两个节点的数据
	public Node createLeftNode(Node root,Object left){
		Node leftNode = new Node(left, null, null);
		root.left = leftNode;
		return leftNode;
	}

	//创造右儿子节点　传入上一节点　和右儿子节点数据
	public Node createRightNode(Node root,Object right){
		Node rightNode = new Node(right, null, null);
		root.right = rightNode;
		return rightNode;
	}
	
	//getter and setter
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
}
