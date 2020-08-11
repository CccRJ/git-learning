package math;

import java.util.Arrays;
import java.util.Stack;

public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        boolean res;
        int[] flag = new int[10];
        //按行检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')continue;
                if(flag[board[i][j] - '0'] == 1){
                    //System.out.println("1:"+i+" "+j);
                    return false;
                }
                else flag[board[i][j] - '0'] = 1;
            }
            Arrays.fill(flag,0);
        }
        //按列检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[j][i] == '.')continue;
                if(flag[board[j][i] - '0'] == 1){
                    //System.out.println("2:"+i+" "+j);
                    return false;
                }
                else flag[board[j][i] - '0'] = 1;
            }
            Arrays.fill(flag,0);
        }
        //存储九宫格左上角位置，按格子查找
        int[][] pos = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for (int k = 0; k < 9; k++) {
            for (int i = pos[k][0]; i < pos[k][0] + 3; i++) {
                for (int j = pos[k][1]; j < pos[k][1] + 3; j++) {
                    if(board[i][j] == '.')continue;
                    if(flag[board[i][j] - '0'] == 1){
                        //System.out.println("3:"+i+" "+j);
                        return false;
                    }
                    else flag[board[i][j] - '0'] = 1;
                }
            }
            Arrays.fill(flag,0);
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] c = {
              {'5','3','.','.','7','.','.','.','.'},
              {'6','.','.','1','9','5','.','.','.'},
              {'.','9','5','.','.','.','.','6','.'},
              {'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},
              {'7','.','.','.','2','.','.','.','6'},
              {'.','6','.','.','.','.','2','8','.'},
              {'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}
            };
        System.out.println(isValidSudoku(c));
    }
    public static String getType(Object test){
        return test.getClass().getName();
    }
}
