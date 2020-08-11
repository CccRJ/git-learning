package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolveNQueens {
    /*
    * 51 皇后问题
    * 回溯
    * */
    private List<List<String>> solveNQueens(int n){
        //初始化棋盘
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(res,0,new ArrayList<String>(),n,board);
        return res;
    }
    private void backtrack(List<List<String>> res,int row,List<String> temp,int len,String[][] board){
        //结束条件
        if(temp.size() == len){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int col = 0; col < len; col++) {
            if(isValid(row,col,board)){
                board[row][col] = "Q";
                //字符串数组转字符串
                StringBuffer str = new StringBuffer();
                for (String s : board[row]) {
                    str.append(s);
                }
                temp.add(str.toString());
                //递归
                backtrack(res,row + 1,temp,len,board);

                //回溯
                temp.remove(temp.size() - 1);
                board[row][col] = ".";
            }
        }
    }
    /*
    * 判断该点是否可以放置皇后
    * */
    private boolean isValid(int row,int col,String[][] board){
        int len = board.length;
        //判断同行同列
        for (int i = 0; i < len; i++) {
            if(board[i][col] == "Q")return false;
            if(board[row][i] == "Q")return false;
        }
        //判断对角线，正对角线 行+列 相等 反对角线 行-列 相等
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i - j == row - col && board[i][j] == "Q")return false;
                if(i + j == row + col && board[i][j] == "Q")return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        System.out.println(s.solveNQueens(4));
    }
}
