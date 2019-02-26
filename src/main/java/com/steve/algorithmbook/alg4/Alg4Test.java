
package com.steve.algorithmbook.alg4;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/** 
 * @ClassName: Alg4Test 
 * @Description: TODO
 * @author: liu
 * @date: Oct 8, 2016 10:16:30 PM  
 */
public class Alg4Test {
	private static final String PATH="/home/liu/cc/WEB-INF";
    
	//构造表达式树
	@Test
	public void conExpTree(){
		//构建一个栈
		Stack stack = new Stack(); 
		String expre = "1 3 + 4 6 7 + * *";
		String[] aStrings = expre.split(" ");
		for(String bString : aStrings){
			//ab+cde+**
		    if(!bString.equals("+") && !bString.equals("*")){
		    	System.out.println(bString);
				stack.push(Integer.valueOf(bString));
			}else{
					//建个树将数据添加在一起
					BinaryTree bTree = new BinaryTree(bString);
					bTree.createLeftNode(bTree.getRoot(), stack.pop());
					bTree.createRightNode(bTree.getRoot(), stack.pop());
					stack.push(bTree);
			}
		}
	}
	@Test
	public void testBinarySearch(){
		BinarySearchTree<Integer> iBinarySearchTree = new BinarySearchTree<>();
		for(int i=1;i<=10;i++){
			iBinarySearchTree.insert(i);
		}
		System.out.println("contains 3 ? "+ iBinarySearchTree.contains(3));
		System.out.println("contains 11 ? "+iBinarySearchTree.contains(11));
		System.out.println("remove 2 " + iBinarySearchTree.remove(2));
		System.out.println("contains 2 ? "+iBinarySearchTree.contains(2));
	}

	@Test
	public void testAvl(){
		Avl<Integer> avl = new Avl<Integer>();
		for(int i=1;i>=10;i++){
			avl.insert(i);
		}
//		System.out.println("contains 3 ? "+ avl.contains(3));
//		avl.remove(3);
//		System.out.println("delete 3 and contains 3 ? " + avl.contains(3));
		avl.printTree();
	}
	//书上作业4.10题
	//列出目录下所有文件的大小和目录结构
	public static void listAll(java.io.File file,int depth){
		//如果是文件夹
		if(file.isDirectory()){
			//列出所有文件在这个文件夹下
			java.io.File[] files = file.listFiles();
			for(java.io.File realFile:files) {
				print(realFile.getName(), depth+1);
				listAll(realFile,depth+1);
			}
		}
	}
	public static void print(String filename,int depth){
		for(int i=0;i<depth;i++){
			System.out.print("  ");
		}
		System.out.println(filename);
	}
	public static void main(String... args){
		java.io.File rootDir = new java.io.File(PATH);
		print(rootDir.getName(),0);
		//书上作业第4.10题
		listAll(rootDir,1);
	}

}
