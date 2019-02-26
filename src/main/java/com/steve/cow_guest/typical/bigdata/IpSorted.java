package com.steve.cow_guest.typical.bigdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: steve
 * @Date: Created in 15:17 2018/3/3
 * @Description: ipv4地址排序
 * @Modified By:
 */
public class IpSorted {

    private Pattern pattern = Pattern.compile("\\d+");
    /**
     * ipv4 地址共有 2^32 个，把每个ipv4地址转换成无符号整数储存
     * @param args
     */
    public static void main(String[] args) {
        IpSorted ipSorted = new IpSorted();
        int a = ipSorted.ipToInt("192.168.1.3");
        String value = ipSorted.intToIp(a);
        System.out.println("ip to int : " + a);
        System.out.println("int to ip : " + value);
    }

    private int ipToInt(String ip){
        Matcher matcher = pattern.matcher(ip);
        int result = 0, count = 0;
        while(matcher.find()){
            int value = Integer.parseInt(matcher.group());
            value = (value << 8 * (3 - count++));
            result = value | result;
        }
        return result;
    }

    private String intToIp(int value){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean needPoint = false;
        for(int i=0; i<4; i++){
            if(needPoint){
                sb.append(".");
            }
            needPoint = true;
            num = (value >> 8 * (3-i)) & 0xff;
            sb.append(num);
        }
        return sb.toString();
    }

}