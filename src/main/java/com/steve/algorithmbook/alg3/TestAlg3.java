package com.steve.algorithmbook.alg3;


import java.util.ArrayList;
import java.util.List;

public class TestAlg3 {

	public void testMyArrayList(){
		MyArrayList<Integer> list = new MyArrayList<>();
		/*
		 * 测试get set add remove 方法
		 * */
//		list.add(3);
//		list.add(5);
//		list.add(9);
//		System.out.println("list.get(1) = "+list.get(1));
//		list.remove(1);
//		System.out.println("list.remove(1) then list.get(1) = " + list.get(1));
//		list.set(9,0);
//		System.out.println("list.set(9,0) then list.get(0) = " + list.get(0));
	    ArrayList<Integer> list2 = new ArrayList<>();
	    list2.add(23);
	    list2.add(34);
		list.addAll(list2);
		for(Integer number : list){
			System.out.println(number);
		}
	}

	public void testMyLinkedList(){
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
//		System.out.println("list.get(0)= "+ list.get(0));
//		list.set(9,0);
//		System.out.println("list.set(9,0) then list.get(0) = " + list.get(0));
//		System.out.println("list.get(0)= "+ list.get(0));
//		System.out.println("list.remove(0) then list.size()= "+list.size());
//		Iterator iterator  = list.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		System.out.println("list.get(4)= "+list.get(4));
		if(list.exchange(3)){
		    System.out.println("list.get(3)= " + list.get(3));
		    System.out.println("list.get(4)= "+list.get(4));
		}
	}

	//3.1 question ascending sequence
	public void test3_1(){
		List<Integer> list= new ArrayList<Integer>();
		List<Integer> list2= new ArrayList<Integer>();
		for(int i=0;i<4;i++){
			int num = (int) (Math.random()*10);
			list2.add(num);
		}
		for(int i=9;i>=0;i--){
			list.add(i);
		}
		printLots(list,list2);
	}
	public void printLots(List l,List p){
		for(int i=0;i<p.size();i++){
			System.out.println(l.get((int) p.get(i)));
		}
		//只调整链来调整元素
	}

	//3.3 question
	public void test3_3(){
		int[] a = new int[]{1,2,2,4,5,6,8,9};
		int[] b = new int[]{2,5,8,9,11,123};
		//计算a交b过程
		int c = a.length;
		int d = b.length;
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		//因为是升序排列的,所以比大小就可以了
			//这只是当序列不是升序排列时才用for循环 最坏情况 N^2
//			for (int i = 1; i < c; i++) {
//				for (int j = 0; j < d; j++) {
//					if (a[i] == b[j]) {
//						if(!list.exists(a[i])){
//					        list.add(a[i]);
//						    break;
//						}
//					}
//				}
//			}
	//这种情况只需线性时间
		int i = 0, j = 0;
		while (true) {
			while (a[i] < b[j]) {
				i++;
				if(i == c){
					break;
				}
			}
			// a[i] >= b[i]
			while (a[i] >= b[j]) {
				if (a[i] == b[j]) {
					list.add(a[i]);
				}
				j++;
				if(j == d){
					break;
				}
			}
			if(i == (c-1) || j == (d-1)){
			    break;
			}
		}
		for(Integer e:list){
			System.out.println(e);
		}
	}

	//question 3.4 canculate a并b 的值
	public void test3_4(){
		int[] a = new int[]{1,2,2,4,5,6,8,9};
		int[] b = new int[]{2,5,8,9,11};
		//计算a并b过程
		int c = a.length; //8
		int d = b.length;//5
		int i = 0, j = 0;
		MyLinkedList<Integer> list = new MyLinkedList<>();
		while(true){
			while(a[i] < b[j]){
				list.add(a[i]);
				i++;
				if(i == c){
					break;
				}
			}
			while(a[i] >= b[j]){
				list.add(b[j]);
				j++;
				if(j == d){
					break;
				}
			}
			if(i == (c-1) || j == (d-1)){
				break;
			}
		}
		for(Integer e:list){
			System.out.println(e);
		}
	}

	//question 3.6
	public void test3_6(){
		//Josephus问题,
		//队列的数组实现,循环数组
		int N = 10,M = 2;
		solve(N,M);
	}
	public void solve(int n,int step){
		int[] a = new int[n];
		for(int i=1;i<=a.length;i++){
			a[i] = i;
		}
		
	}
}
