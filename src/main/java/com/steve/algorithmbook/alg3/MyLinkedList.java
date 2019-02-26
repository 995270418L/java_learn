/**   
 * 
 * @Title: MyLinkedList.java 
 * @Prject: TestForJava
 * @Package: floder.com.alg3 
 * @Description: TODO
 * @author: liu   
 * @date: Oct 3, 2016 10:29:20 PM 
 * @version: V1.0   
 */
package com.steve.algorithmbook.alg3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * @ClassName: MyLinkedList 
 * @Description: LinkedList 泛型类实现,双链表结构
 * @author: liu
 * @date: Oct 3, 2016 10:29:20 PM  
 */
public class MyLinkedList<T> implements Iterable<T> {

	/*
	 * 建立嵌套类,表示双链表结构
	 * */
	private static class Node<T>{
		private Node<T> prev;
		private T data;
		private Node<T> next; 
		public Node(Node<T> p,T d,Node<T> n){
			data = d;
			prev = p;
			next = n;
		}
	}

	/*
	 * 设置头节点和尾节点
	 * */
	 private Node<T> first;
	 
	 private Node<T> tail;
	 //集合的大小
	 private int theSize;
	 //附加数据域,用来检测集合中的变化
	 private int modCount;
	 /*
	  * 初始化链表,不能加泛型表示
	  * */
	 public MyLinkedList(){
		 //头尾节点相连
		 first = new Node<T>(null,null,null);
		 tail = new Node<T>(first, null, null);
		 first.next = tail;
		 theSize = 0;
		 modCount++;
	 }
	 //监测链表状态的附加方法
	 public int size(){
		 return theSize;
	 }
	 public boolean isEmpty(){
		 return size() == 0;
	 }

	 /*
	 * 设置add remove get set size 等方法
	 * */
	 public boolean add(T data){
	     add(size(),data);
	     return true;
	 }

	 public void add(int index,T x){
		 //首先需要获得该位置的节点数据,然后再在该节点插入新节点
		 addBefore(getNode(index),x);
	 }

	 public T get(int index){
		 return getNode(index).data;
	 }
	 //返回被替换的值
	 public T set(T t,int index){
		 //首先应该remove原来的节点,再在原来的节点上add this node
		 //上面的想法真实个垃圾的想法,从一开始就错了,应该是这样直接替换数据,前后节点指向不变.
		 Node<T> pNode = getNode(index);
		 T x = pNode.data;
		 pNode.data = t;
		 return x;
	 }
	 public Node<T> remove(int index){
		 if(index < 0 || index > size()){
			 throw new IndexOutOfBoundsException();
		 }
		 //首先需要get this node
		 Node<T> p = getNode(index);
		 //p 节点的前一个节点的末尾就指向p的后一个节点,not enough
		 p.prev.next = p.next;
		 //还需要给p 节点的后一个节点的prev指定节点
		 p.next.prev = p.prev;
		 theSize --;
		 modCount ++;
		 return p;
	 }
	 public void addBefore(Node<T> node,T x){
		 //新节点的前一个节点就是老节点的前一个节点,后一个节点解释老节点自己
		 Node<T> addNode = new Node<T>(node.prev, x, node);
		 //得到了新节点,再重新给前后节点指定prev和next locationx
		 //如果node 为first,则指向自己
		 addNode.prev.next = addNode;
		 //这个等价于 node = addNode.next;
		 node.prev = addNode;
		 theSize ++;
		 modCount ++;
	 }
	 //由于节点是根据前后节点的位置来判定的,所以没必要对size的大小-1
	 public Node<T> getNode(int index){
		 Node<T> p;
		 if(index < 0 || index > size()){
			 throw new IndexOutOfBoundsException();
		 }
		 //二分法减少循环次数,返回前一个节点的后一个节点,真是牛逼
		 if(index < size()/2){
			 p = first.next;
			 //往后找x
			 for(int i=0; i < index ;i++){
				 p = p.next;
			 }
			 //else 返回后一个节点的前一节点,只需要一个节点即可确定节点位置
		 }else{
			 p = tail;
			 //往前找
			 for(int i = size() ;i > index;i--){
				 p = p.prev;
			 }
		 }
	     return p;
	 }
	 
	 //只调整链来调整元素
	 /** 
	 * @Title: change 
	 * @Description: TODO
	 * @return: void
	 */
	public boolean exchange(int s){
		 Node<T> node = getNode(s);
		 Node<T> node2 = getNode(s+1);
		 node.next = node2.next;
		 node2.prev = node.prev;
		 node.prev = node2;
		 node2.next = node;
		 return true;
	}
	//需要考虑的情况,当链表大小为0,为1时tail is null
	public boolean exists(T t){
		if(size()==0){
			return false;
		}
		//切记不能递归首尾节点,那是标识,得新建一个节点,否则等会addBefore就会出错,切记切记.
		Node<T> p; 
		p = first.next;
		for(int i=0;i<size()/2;i++){
			T data = p.data;
			if(data == null){
				return false;
			}
			if(data.equals(t)){
				return true;
			}
			p= p.next;
		}
		p = tail.prev;
		for(int i=size();i>size()/2;i--){
			//考虑为大小1的情况,tail为null,首先需要验证tail.prev是否为相等
			T data = p.data;
			if(data == null){
				return false;
			}
			if(data.equals(t)){
				return true;
			}
			p = p.prev;
		}
		return false;
	}
	/* 
	 * @Title: iterator
	 * @Description: 继承Iterable方法,实现hasNext() next() 方法
	 * @return 
	 * @see java.lang.Iterable#iterator() 
	 */
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private Node<T> current = first.next;
			private int exspectModCount = modCount;
			private boolean okToRemove = false;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current != tail;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(modCount != exspectModCount){
					throw new ConcurrentModificationException();
				}
				if(!hasNext()){
					throw new NoSuchElementException();
				}
				T t = current.data;
				current = current.next;
				okToRemove = true;
				return t;
			}	
		};
	}
	
	//getter and setter
	public Node<T> getFirst() {
		return first;
	}
	public void setFirst(Node<T> first) {
		this.first = first;
	}
	public Node<T> getTail() {
		return tail;
	}
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	public int getTheSize() {
		return theSize;
	}
	public void setTheSize(int theSize) {
		this.theSize = theSize;
	}
	public int getModCount() {
		return modCount;
	}
	public void setModCount(int modCount) {
		this.modCount = modCount;
	}

}
