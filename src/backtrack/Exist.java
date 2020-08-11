package backtrack;

import java.util.Arrays;

public class Exist {
    /*
    * 79 单词搜索 回溯算法
    * */
    private boolean res;
    public boolean exist(char[][] board,String word){
        //判空
        if(word.length() == 0 || board.length == 0) return false;
        //初始化
        boolean[][] used = new boolean[board.length][board[0].length];
        backtrack(0,board,used,word,0,0);
        return res;
    }
    private void backtrack(int temp,char[][] board,boolean[][] used,String word,int row,int col){

        if(temp == word.length() && board[row][col] == word.charAt(word.length() - 1)){
            res = true;
            return;
        }
        //找字母初始位置
        if(temp == 0){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //有了结果只解结束，节省时间
                    if(res)return;
                    if(board[i][j] == word.charAt(0)){
                        used[i][j] = true;
                        backtrack(temp + 1,board,used,word,i,j);
                        used[i][j] = false;
                    }
                }
            }
        }
        else{
            //有结果直接结束
            if(res)return;
            //上
            if(row > 0 && !used[row - 1][col] && board[row - 1][col] == word.charAt(temp)){
                used[row-1][col] = true;
                backtrack(temp + 1,board,used,word,row - 1,col);
                used[row-1][col] = false;
            }
            //下
            if(row < board.length - 1 && !used[row + 1][col] && board[row + 1][col] == word.charAt(temp)){
                used[row+1][col] = true;
                backtrack(temp + 1,board,used,word,row + 1,col);
                used[row+1][col] = false;
            }
            //左
            if(col > 0 && !used[row][col - 1] && board[row][col - 1] == word.charAt(temp)){
                used[row][col-1] = true;
                backtrack(temp + 1,board,used,word,row,col - 1);
                used[row][col-1] = false;
            }
            //右
            if(col < board[0].length - 1 && !used[row][col + 1] && board[row][col + 1] == word.charAt(temp)){
                used[row][col+1] = true;
                backtrack(temp + 1,board,used,word,row,col + 1);
                used[row][col+1] = false;
            }
        }
    }

    
    
    /*
    * 另一种解法
    * */
    //初始化
    private boolean[][] used;
    //      x-1,y
    //x,y-1  x,y   x,y+1
    //      x+1,y
    private int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
    private int row,col;
    private String word;
    private char[][] board;
    private boolean ans;
    
    public boolean exist2(char[][] board,String word){
        row = board.length;
        if(row == 0)return false;
        col = board[0].length;
        used = new boolean[row][col];
        this.word = word;
        this.board = board;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(backtrack(i,j,0))
                    return true;
            }
        }
        return false;
    }
    //回溯
    private boolean backtrack(int row,int col,int start){
        if(start == word.length() - 1){
            return board[row][col] == word.charAt(start);
        }
        if(board[row][col] == word.charAt(start)){
            used[row][col] = true;
            for (int n = 0; n < 4; n++) {
                //选择方向
                int x = row + direction[n][0];
                int y = col + direction[n][1];
                if (isValid(x,y) && !used[x][y]){
                    if(backtrack(x,y,start + 1))return true;
                }
            }
            used[row][col] = false;
        }
        return false;
    }
    //判断是否在范围内
    private boolean isValid(int x,int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    
    public static void main(String[] args) {
        Exist e = new Exist();
        System.out.println(e.exist(new char[][]{{'a','b','b'}},"abb"));
    }
}
