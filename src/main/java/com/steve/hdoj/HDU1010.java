package com.steve.hdoj;

import java.util.Scanner;

/**
 * Created by liu on 11/15/16.
 * 有一只狗要吃骨头，结果进入了一个迷宫陷阱，迷宫里每走过一个地板费时一秒，该地板
 *   就会在下一秒塌陷，所以你不能在该地板上逗留。迷宫里面有一个门，只能在特定的某一秒才能打开，
 *   让狗逃出去。现在题目告诉你迷宫的大小和门打开的时间，问你狗可不可以逃出去，可以就输出YES,否则NO。
 */
public class HDU1010 {

    /*
    * 判断是否解决
    * */
    private static boolean solved = false;

    /*
    * 规定的时间
    * */
    private static int T = 0;

    /*
    * rectangle　size
    * */
    private static int N; //横坐标
    private static int M; //竖坐标

    /*
    * 终点坐标
    * */
    private static int ex = 0;
    private static int ey = 0;

    /*
    * 图
    * */
    private static String[][] map;
    /*
    * 标记是否起点(不能回到起点)
    * */
    private static boolean[][] arrd;

    /*
    * 上右下左　四个方向
    * */
    private static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String... args){
        System.out.println("program 开始");
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        while(N!=0 && M!=0 && T!=0){
            System.out.println("开始输入图");
            map = new String[N][M];
            arrd = new boolean[N][M];
            int sx=0,sy=0;
            //不可通行的点
            int xnum = 0;
            for(int i=0;i < N; i++) {
                for (int j=0; j < M; j++) {
                    map[i][j] = sc.next();
                    arrd[i][j] = false;
                    //起点
                    //记录起点坐标
                    if(map[i][j].equals("S")){
                        sx = i;
                        sy = j;
                        arrd[i][j] = true;
                    }
                    //标记不可穿过去的点
                    if(map[i][j].equals("X")){
                        xnum ++;
                    }
                    if(map[i][j].equals("D")){
                        ex = i;
                        ey = j;
                    }
                }
                System.out.println("输入完一组");
            }
            //只有当可通行的点大于时间T时，才可以进行dfs
            if(N*M - xnum > T){
                //起始步数为0
                dfs(sx,sy,0);
            }
            if(solved)
                System.out.println("YES");
            else
                System.out.println("NO");
            N = sc.nextInt();
            M = sc.nextInt();
            T = sc.nextInt();
            System.out.println("program end");
        }
    }
    //深度优先搜索就是循环+递归
    public static void dfs(int sx,int sy,int step){
        if(solved) return;
        if(step==T && map[sx][sy].equals("D")){
            solved = true;
            return;
        }
        //如果当前步数已经大于T了，就没必要走了(剪枝)
        if(step > T){
            return;
        }
        int dis = T - step - distance(sx,sy);
        //如果在规定的步数里没有到达，就舍弃该点。
        if(dis < 0 ){
            return;
        }
        for(int i=0;i<4;i++){
            //开始向前搜索
            int tx = sx + dir[i][0];
            int ty = sy + dir[i][1];
            int tstep = step + 1 ;
            if(tx>=0 && tx < N && ty>=0 && ty<M && !map[tx][ty].equals("X") && !arrd[tx][ty]){
                arrd[tx][ty] = true;
                dfs(tx,ty,tstep);
                arrd[tx][ty] = false;
            }
        }
    }
    //若在规定的时间内(T)没有到达指定的位置，就没必要走了(T - step < dis)
    //当前位置(x,y)和终点坐标的距离
    public static int distance(int x,int y){
        return Math.abs(x-ex) + Math.abs(y-ey);
    }
}
