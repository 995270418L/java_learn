package com.steve.algorithms.recruit;

/**
 *
 * 999. 车的可用捕获量
 *
 */
public class Question_999 {

    public int numRookCaptures(char[][] board) {
        int i=0, j=0;
        for(; i<8; i++){
            boolean find = false;
            for(j=0; j < 8; j++){
                if(board[i][j] == 'R'){
                    find = true;
                    break;
                }
            }
            if(find) break;
        }
        int res = 0;
        while (i >= 0){
            char c = board[i--][j];
            if(c == 'p'){
                res ++;
                break;
            }else if(c  == 'B'){
                break;
            }
        }
        while (i < 8){
            char c = board[i++][j];
            if(c == 'p'){
                res ++;
                break;
            }else if(c  == 'B'){
                break;
            }
        }
        while (j >= 0){
            char c = board[i][j--];
            if(c == 'p'){
                res ++;
                break;
            }else if(c  == 'B'){
                break;
            }
        }
        while (j < 8){
            char c = board[i][j++];
            if(c == 'p'){
                res ++;
                break;
            }else if(c  == 'B'){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question_999 question = new Question_999();
        int[] arr = {0, 0, 1, 2, 4, 2 ,2, 3, 1, 4};
        char[][] board = {{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(question.numRookCaptures(board));
    }

}
