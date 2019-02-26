package com.steve.grammer;

/**
 * Created by liu on 3/13/17.
 * 计算水洼的数量
 */
public class LakeCount {
    //构建数据
    static char[][] a= {{'w','.','.','.','.','.','.','.','.','w','w','.'},{'.','w','w','.','.','.','.','.','.','w','w','w'},
                        {'.','.','.','.','w','w','.','.','.','w','w','.'},{'.','.','.','.','.','.','.','.','.','w','w','.'},
                        {'.','.','.','.','.','.','.','.','.','w','.','.'},{'.','.','w','.','.','.','.','.','.','w','.','.'},
                        {'.','w','.','w','.','.','.','.','.','w','w','.'},{'w','.','w','.','w','.','.','.','.','.','w','.'},
                        {'.','w','.','w','.','.','.','.','.','.','w','.'},{'.','.','w','.','.','.','.','.','.','.','w','.'}};

    static int N =10,M=12;   //N 为行 M 为行值

    public static void main(String... args){
        int res = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(a[i][j] == 'w') {
                    dfs(i,j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void dfs(int x,int y){
        int nx,ny;
        //将现在所处的地方变为'.'
        a[x][y] = '.';
        //根据x,y的坐标从他的身边找8个相对的值,全部令其变为'.'
        //位移值
        for(int dx = -1 ;dx <= 1 ; dx++){
            for(int dy = -1; dy <= 1 ; dy++){
               //实际坐标
                nx = x + dx;ny = y + dy;
                if( 0 <= nx && nx < N && 0<= ny && ny < M && a[nx][ny] == 'w') dfs(nx,ny);
            }
        }
        return ;
    }
}
