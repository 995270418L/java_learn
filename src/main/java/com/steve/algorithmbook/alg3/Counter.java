/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: Counter.java 
 * @Prject: TestForJava
 * @Package: floder.com.alg3 
 * @Description: TODO
 * @author: liu   
 * @date: Oct 4, 2016 11:17:05 PM 
 * @version: V1.0   
 */
package com.steve.algorithmbook.alg3;

import java.util.Scanner;
import java.util.Stack;

/** 
 * @ClassName: Counter 
 * @Description: 后缀表达式实现计算器功能
 * @author: liu
 * @date: Oct 4, 2016 11:17:05 PM  
 */
public class Counter {

	/*计算示例
	 *1. 输入 4.99*1.06 + 5.99 + 6.99*1.06
	 *2. 输入 4.99 + 5.99*1.06 + (6.99*1.06+7.99)*1.06
	 *
	 * 有一个判断运算符的优先级的功能不知道怎么实现,算了.mdzz
	 * */
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入计算式(q退出输入): ");
		//用栈来计算
		Stack<String> stack = new Stack<String>();
		while(!scanner.nextLine().equals("q")){
			String cc = scanner.nextLine();
			boolean b = isNumber(cc);
			MyArrayList<Double> list = new MyArrayList<>();
			//如果b不是运算符
			if(b){
				Double double1 = Double.valueOf(cc);
				//判断cc是否为数字 true
				if(double1>=0.00){
					list.add(double1);
				}else{
					System.out.println("请输入正确的格式!");
					cc = scanner.nextLine();
				}
			}else{
				
			}
		}
	}
	public static boolean isNumber(String a){
		if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("(") || a.equals(")")){
			//a 是运算符
			return false;
		}else{
			return true;
		}
	}
}
