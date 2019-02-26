package com.steve.algorithmbook.alg2;

/*
 * 求最大子序列和的问题
 * */
public class Suquence {
	private static int[] a = {1,-2,7,-4,8,10,-7,2,3,4,1,-1,4,-4,1,-3,-2,4,1,9,-3,1}; 
	private static int thisSum = 0;
	private static int maxSum = 0;
	
	public static void main(String[] args){
//        int max = list3(a,0,a.length-1);
		long j = System.currentTimeMillis();
		for(int i=0;i<10000000;i++){
//			shellSort(a);
			quickSort(a,0,a.length-1);
		}
//		quickSort(a,0,a.length-1);
//		for(int i=0;i<a.length;i++){
//			System.out.print(a[i]+"\t");
//		}
		long k = System.currentTimeMillis(); // list3 5112 list1 8111 list4 799 list2 2564
		System.out.println(k-j);
        //System.out.println(max);
	}
    //求最大子序列和的四种方法
	//常规思路 O(N^3)
	public static int list1(int[] a){
		for(int i=0;i<a.length;i++){
		  for(int j=i;j<a.length;j++){
			  thisSum = 0;
			  for(int k=j;k<=i;k++){
				  thisSum += a[k];
			  }
			  if(thisSum > maxSum)
				  maxSum = thisSum;
		  }
		}
		return maxSum;
	}
	//省略一个for循环
	public static int list2(int[] a){
		for(int i=0;i<a.length;i++){
		    thisSum = 0;
		    for(int j=i;j<a.length;j++){
		    	thisSum += a[j];
		    	if(thisSum > maxSum){
		    		maxSum = thisSum;
		    	}
		    }
		}
		return maxSum;
	}
	//采用分而治之的思想,分左右两部份,分别求左边最大序列和,右边序列和,全部的序列和,三者取最大值
	//O(N*LogN)
	public static int list3(int[] a,int left,int right){
		//取一个退出递归的条件,即当左边等于右边时返回a[left] or a[right]
		if(left == right){
			if(a[left] > 0){
				return a[left];
			}else{
				return 0;
			}
		}
		int center = (left + right)/2;//总是偏向left
		
		//这两行代码的作用就是分队列,
		int maxLeftSum = list3(a, left, center);
		int maxRightSum = list3(a, center+1, right);
		//此处maxLeftBoardSum 是左边界部分的和
		int thisLeftSum = 0,maxLeftBoardSum = 0;
		for(int i = center;i>=left;i--){
			thisLeftSum += a[i];
			if(thisLeftSum >maxLeftBoardSum){
				maxLeftBoardSum = thisLeftSum;
			}
		}
		//同上,maxRightBoardSum 是右边界部分的和
		int thisRightSum = 0, maxRightBoardSum = 0;
		for(int i=center+1;i<=right;i++){
			thisRightSum += a[i];
			if(thisRightSum > maxRightBoardSum){
				maxRightBoardSum = thisRightSum;
			}
		}
		return max3(maxLeftSum,maxRightSum,maxLeftBoardSum+maxRightBoardSum);
	}
	public static int max3(int a,int b,int c){
		int max = a ;
		if(b>c){
			if(b>a){
				max = b;
			}
		}else{
			if(c>a){
				max = c;
			}
		}
		return max;
	}
	//联机算法
	//O(N)[5,-2,6,4,5,-1,7]
	/*
	* 1.如果thisSum<0,意味着加上thisSum对thisSum以后的连加来说是减少的
	* */
	public static int list4(int[] a){
		for(int i= 0;i<a.length;i++){
			thisSum += a[i];
			if(thisSum > maxSum){
				maxSum = thisSum;
			}else if(thisSum <0){
				thisSum = 0;
			}
		}
		return maxSum;
	}
	/*
	* 写个快排(分而治之) 这种快排只适合pivor为a[left]的情况
	*
	*  1.找基准数,从末尾开始找比它小的数，找寻的条件就是左边界小于右边界．减１再找，直到左边＝＝右边，若提前找到，则左边加１，开始从左边的位置开始加１开始找，这就是条件一样
	*  　当左边＝＝右边时，将基准数赋值给左边的数(此时左右两边相等，无所谓哪边).剩下的左右两区间再重复这样的步骤，直到排序完成． 还明白一个道理，二分法不一定要一开始就分界线.
	*     如果数组不是指针，java该何去何从．
	*
	* */
	public static void  quickSort(int[] a, int left, int right){
		if(left + 10 < right){
			//这个是为了二分而准备的
			int i=left, j = right;
			//这就是基准数
			int x = a[left];
			//什么时候用while,什么时候用for循环，当判断条件多的时候用while更简洁.for更容易看出大O的时间
//			while(i<j){
//				//从右边开始找比基准数小的，找到返回右边的位置
//				while(i<j && a[j] >= x){
//					j--;
//				}
//				if(i < j){
//					//赋完值再加１
//					a[i++] = a[j];
//				}
//				//从左边开始找比基准数大的，比基准数大的话，当然比刚才右边的哪个数要大一点咯，找到返回左边的位置
//				while(i<j && a[i]<=x){
//					i++;
//				}
//				if(i<j){
//					a[j--]=a[i];
//				}
//			}
			//for 循环主要是增加了自增这一功能
			for(int k=i;k<j;k++){
				//如果不是　>=　号, 7,6,5,7,7,8(0,5) -> 7,6,5,7,7,8(3,3) -> quickSort(a,0,3) ->7,6,5,7(0,3) -> 7,6,5,7(3,3) ->　死循环了,怪不得会发生stackOverflow
				//这也可以改成for 循环，不过没必要，灵活运用吧。
				while(i<j && a[j]>=x){
					j--;
				}
				if(i<j)
					a[i++] = a[j];
				while(i<j && a[i]<x){
					i++;
				}
				if(i<j)
					a[j--]=a[i];
			}
			//当这个循环结束时，i == j;定位基准数．
			a[i] = x;
			//以i为基准，左右再次进行排序，此时左边和右边已经有一点排序的迹象了．
			quickSort(a,left,i);
			quickSort(a,i+1,right);
		}else{
			insertSort(a);
		}
	}

	/*
	* 插入排序，数字依次与后一个数字比较，所以基准数是最前面的数
	* */
	public static void insertSort(int[] a){
		int j=0;
		for(int i=1;i<a.length;i++){
			int pivor = a[i];
			//这里的比较是大于或者等于都可以
			for(j=i ; j > 0 && a[j-1] >= pivor ; j--){
				a[j] = a[j-1];
			}
			a[j]=pivor;
		}

	}
	/*
	* 希尔排序
	* 	向后比较的间隔随着排序的进行而不断的变化
	* */
	public static void shellSort(int[] a){
		for(int gap = a.length/2; gap > 0; gap /= 2){
			int j=0;
			for(int i=gap; i<a.length; i++){
				int pivor = a[i];
				for( j = i; j >=gap && a[j-gap] > pivor; j -= gap)
					a[j] = a[j-gap];
				a[j] = pivor;
			}
		}
	}
	/*
	* 冒泡排序(不需要绕过相等的数)
	* 	外层循环控制比较的次数(数组大小-1,其实这样就产生了额外的漏洞:万一数组后半部分是排序好了的，就会多几次不必要的循环比较)
	*   内层循环控制数值的冒泡(将最大的数"冒"出来,放到数组的尾端)
	*
	* */
	public static void bubbleSort(int[] a){
		for(int i=0 ;i<a.length-1;i++){

			for(int j=1 ; j<a.length-i; j++){
				if(a[j] < a[j-1]){
					int tmp2 = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp2;
				}
			}
		}
	}

	/*
	* 选择排序
	* 	选择一个最小(大)值的位置，每次都放在数组第一(最后)的位置，完成排序。
	* */
	public static void selectSort(int[] a){
		for(int i=0 ; i<a.length-1 ; i++){
			int min = i;
			for(int j=i+1;j<a.length;i++)
				if(a[j]<a[min])
					min = j;
			int tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}
}
