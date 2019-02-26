/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: CircleArray.java 
 * @Prject: TestForJava
 * @Package: floder.com.alg3 
 * @Description: TODO
 * @author: liu   
 * @date: Oct 6, 2016 1:41:19 AM 
 * @version: V1.0   
 */
package com.steve.algorithmbook.alg3;

import java.util.Iterator;

/** 
 * @ClassName: 队列的数组实现(队列有固定大小的)
 * @Description: TODO
 * @author: liu
 * @date: Oct 6, 2016 1:41:19 AM  
 */
public class CircleArray<T> implements Iterable<T>{
	
	private static final int DEFAULT_SIZE = 10;
	
	private T[] t = null;
	
	//标记循环数组初始位置和末尾位置,开始都标记第一个位置
	private int front = 0;
	
	private int back = 0;
	
	private int currentSize ;
	
	public int size(){
		return currentSize;
	}

	 /**
	 * @Title:CircleArray
	 * @Description:TODO  
	 */
	public CircleArray() {
		//得到固定队列的大小 为10
		T[] ts = (T[]) new Object[DEFAULT_SIZE];
		for(int i=0;i<DEFAULT_SIZE;i++){
			t[i] = ts[i];
		}
	}
	
	public boolean enqueue(T x){
		enqueue(size(),x);
		return true;
	}
	public void enqueue(int idx,T x){
	    back ++;
	    currentSize ++;
	    t[idx] = x;
	    //当back下标等于默认大小时,需要将back指向front
	    if(back == DEFAULT_SIZE){
	    	
	    }
	}
	public T dequeue(){
		front ++;
		currentSize --;
		return t[currentSize-1];
	}
	/* (non Javadoc) 
	 * @Title: iterator
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Iterable#iterator() 
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
