package com.steve.algorithms.recruit;

/**
 * 面试题13. 机器人的运动范围
 */
public class Question_13 {

    public static void main(String[] args) {
        Question_13 question = new Question_13();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int target = question.movingCountDFS(1, 2, 1);  // 16, 8, 4
        System.out.println(target);
    }

    /**
     * 暴力法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isArea(i, j, k)) {
                    res++;
                    System.out.println("i\t" + i + "\tj\t" + j);
                }
            }
        }
        return res;
    }

    /**
     * dfs
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCountDFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        int val = i / 10 + i % 10 + j / 10 + j % 10;
        if (i < 0 || i >= m || j < 0 || j >= n || val > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i - 1, j, m, n, k, visited) + dfs(i + 1, j, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
    }

    public boolean isArea(int m, int n, int k) {
        int res = 0;
        while (m != 0 || n != 0) {
            res += m % 10;
            res += n % 10;
            if (res > k) return false;
            m /= 10;
            n /= 10;
        }
        return res <= k;
    }

}
