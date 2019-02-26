package com.steve.algorithmbook.alg3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 模拟arrayList的实现(List ADT可增长数组的实现)
 * */
public class MyArrayList<T> implements  Iterable<T> {
	/*
	 * 数组的初始容量
	 * */
	private static final int DEFAULT_CAPACITY = 10;
	/*
	 * 数组的当前容量 默认为0;
	 * */
	private int theSize ;
	/*
	 * Integer 数组
	 * */
	private T[] theItem;
    public MyArrayList() {
		Clear();
	}
    public void Clear(){
    	theSize = 0;
    	/*
    	 * 扩容方法
    	 * */
    	ensureCapacity(DEFAULT_CAPACITY);
    }
	public void ensureCapacity(int newCapacity){
		if(newCapacity < theSize){
			return;
		}
		T[] old = theItem;
		
		/*泛型数组的创建是违法的,所以这里通过一个对象数组强制类型转换来实现,
		*会产生一个警告,但这在泛型数组的实现过程是必须的.
		*/
	    theItem = (T[]) new Object[newCapacity];
	    for(int i=0;i<size();i++){
	        theItem[i] = old[i];
	    }
	    
	}
	/*
	 * 返回数组的大小
	 * */
	private int size() {
		return theSize;
	}
	/*
	 * 判断数组大小是否为0
	 * */
	public boolean isEmpty(){
		return size()==0;
	} 
	/*
	 * 数组的get和set方法
	 * */
	public T get(int index){
		//先判断
		if(index <0 || index >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItem[index];
	}
	public T set(T value,int index){
		//先判断
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T old = theItem[index];
		theItem[index] = value;
		return old;
	}
	
	/*
	 * add方法
	 * */
	public boolean add(T value){
		add(size(),value);
		return true;
	}

	public void add(int index,T value){
		/*
		 * 如果待添加的数组长度刚好等于数组的大小,则扩容2倍+1
		 * */
		if(theItem.length == size())
			ensureCapacity(size()*2 +1);
		for(int i = theSize;i > index;i--){
			//因为i的初始位置为数组的最大值,变为新数组时在原来的位置上 +1
			theItem[i] = theItem[i-1];
		}
		theItem[index] = value;
		theSize ++;
	}

	public boolean addAll(Collection<? extends T> items){
		Object[] a = items.toArray();
		int number = a.length;
		ensureCapacity(size()+number);
		System.arraycopy(a, 0, theItem, size(), number);
		return true;
	}

	/*
	 * remove方法
	 * */
	public T remove(int index){
		//remove就不需要扩容了
		T removeItem = theItem[index];
		for(int i=index;i<size()-1;i++){
			theItem[i] = theItem[i+1];
 		}
		theSize --;
		return removeItem;
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int current = 0;
			@Override
			public boolean hasNext() {
				return current < size();
			}
			@Override
			public T next() {
				if(!hasNext()){
					throw new NoSuchElementException();
				}
				return theItem[current++];
			}
			public void remove(){
				MyArrayList.this.remove(--current);
			}
		};
	}
}
