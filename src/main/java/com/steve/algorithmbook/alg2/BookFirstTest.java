package com.steve.algorithmbook.alg2;

public class BookFirstTest {
	//数据结构预算法第一章练习题
	private static int n=6;
	private static int n2 = 100;
		
	public static void main(String[] args){
		long b = test2_6a(n);
		System.out.println(b);
	}
   
	//2-6 a
	public static long test2_6a(int n){
		if(n==1){
			return 2;
		}
		return (long) Math.pow(test2_6a(n-1),2);
	}
}
