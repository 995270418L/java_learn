package com.steve.algorithms.repeat.recursive;

import com.google.common.collect.Lists;
import com.sun.javafx.sg.prism.NGExternalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class PasacTriangle {


    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0 ;i<numRows; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j <= i; j++){
                tmp.add(helper(i, j));
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>();
        for(int j=0; j <= rowIndex; j++){
            tmp.add(helper(rowIndex, j));
        }
        return tmp;
    }

    /**
     * 生成第 i 行， 第 j 列的数据
     * @param row
     * @param j
     * @return
     */
    public int helper(int row, int j){
        if(row == 0){
            return 1;
        }
        if(j == 0 || j == row) {
            return 1;
        }else{
            return helper(row - 1, j - 1) + helper(row -1, j);
        }
    }

    public static void main(String[] args) {
        PasacTriangle question = new PasacTriangle();
//        System.out.println(question.generate(30)); // 超出时间限制
        System.out.println(question.getRow(3));
    }
}