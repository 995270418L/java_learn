package com.steve.hdoj

/**
 * Created by liu on 10/28/16.
 */
class NumberSequence {

    /*A number sequence is defined as follows:
    f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
    Given A, B, and n, you are to calculate the value of f(n).

   input:
       1 1 3
       1 2 10
       0 0 0
   output:
        2
        5
    */
    static void main(args){
        Scanner sc =new Scanner(System.in);
        println "输入三个数字"
        int A =sc.nextInt();
        int B = sc.nextInt();
        int n = sc.nextInt();
        println recursion(n,A,B);

    }
    static int recursion(int n,int A,int B){
        if(n<3){
            return 1
        }
        return (A*recursion(n-1,A,B) + B * recursion(n-2,A,B))%7
    }
}
