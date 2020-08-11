package BFSDFS;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 130 被围绕的区域填充
 * @author: ChaiRJ
 * @create: 2020-02-26 23:13
 **/
public class Solve {
    public void solve(char[][] board){
        if (board == null || board.length == 0)return;
        int xLen = board.length,yLen = board[0].length;
        //扫描所有边界的O
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(i == 0 || j == 0 || i == xLen - 1 || j == yLen - 1){
                    if (board[i][j] == 'O')
                        dfs(board,i,j);
                }
            }
        }
        //被围绕的O改为X，*变为O
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        //找到所有和边相连的节点
        int xLen = board.length, yLen = board[0].length;
        if(i < 0 || j < 0 || i >= xLen || j >= yLen || board[i][j] == '*' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '*';
        //检查周围方向
        dfs(board,i + 1,j);
        dfs(board,i - 1,j);
        dfs(board,i,j + 1);
        dfs(board,i,j - 1);
    }

    public static void main(String[] args) {
        Solve s = new Solve();
        s.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
