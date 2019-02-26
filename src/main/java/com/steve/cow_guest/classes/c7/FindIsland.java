package com.steve.cow_guest.classes.c7;

/**
 * 从矩阵中找寻小岛
 * 1 1 1 0 0 0
 * 0 0 1 1 0 0
 * 0 1 0 1 0 0
 *当1连接在一起时，则称有一个小岛。
 *用污染法，当发现有一个 1 时，将数字污染成2 ，然后继续传递到上下左右四个方向。
 *
 *
 *
 * 多计算机分布式任务计算方式:
 *      也是污染的方式，但是计算边界的时候如果边界重复了一次就要 -1 ,那么怎么处理边界就是概要讨论的事情了。
 * 这里使用并查集的数据结构。查询两个边界节点的父节点(isSameSet)，不是，就执行union操作，小岛总数 -1，再往下判断边界(isSameSet),
 * 结果是,就继续往下执行判断。（code还没有，有点能力超纲）
 */
public class FindIsland {

    public static int fil(int[][] src){
        if(src == null){
            return 0;
        }
        int res = 0;
        int N = src.length;
        int M = src[0].length;
        for(int i=0; i<N ;i++){
            for(int j=0;j<M;j++){
                if(src[i][j] == 1){
                    res ++;
                    infection(src,i,j,N,M);
                }
            }
        }
        return res;
    }

    private static void infection(int[][] src, int i, int j, int n, int m) {
        if( i < 0 || i >= n || j < 0 || j >= m || src[i][j] != 1){
            return ;
        }
        src[i][j] = 2;
        infection(src,i-1,j,n,m);
        infection(src,i+1,j,n,m);
        infection(src,i,j-1,n,m);
        infection(src,i,j+1,n,m);
    }

    public static void main(String[] args) {
        int[][] src = {
                {1,1,1,1},
                {1,0,0,0},
                {0,0,0,1},
                {0,0,1,1}
        };
        System.out.println(fil(src));
    }

}
