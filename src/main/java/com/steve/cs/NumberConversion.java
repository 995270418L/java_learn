package com.steve.cs;

import java.io.UnsupportedEncodingException;

/**
 * @Author: steve
 * @Date: Created in 10:36 2018/5/25
 * @Description: 进制数转换类的实现。
 * @Modified By:
 */
public class NumberConversion {

    /**
     * 二进制转换成10进制(加权法)
     * @param two
     * @return
     */
    public static int twoConversionToTen(byte[] two){
        int result = 0;
        for(int i=1;i<two.length;i++){
            result += two[i]*Math.pow(2,i-1);
        }
        return result;
    }

    /**
     * 10进制转换成二进制（无小数部分）,连除法
     * @param ten
     * @return
     */
    public static String tenConversionToTwo(int ten) throws UnsupportedEncodingException {
        int len = 1;
        int tenTemF = ten;
        while(true){
            if((tenTemF /= 2 ) != 0){
                len += 1;
            }else{
                break;
            }
        }
        int tenTem = ten;
        byte[] result = new byte[len];
        for(int i=len-1 ;i >= 0; i--){
            if((tenTem /=2) != 0){
                result[i] = (byte) (ten%2);
                ten = ten/2;
            }else{
                result[i] = 1;
            }
        }
        return new String(result,"UTF-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("result: " + tenConversionToTwo(8));
    }
}
