package 剑指Offer;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * @author: ChaiRJ
 * @create: 2020-07-16 13:51
 **/
public class SpiralOrder29 {
    private int[] dirX = new int[]{0, 1, 0, -1};
    private int[] dirY = new int[]{1, 0, -1, 0};
    private boolean[][] visited;
    public int[] spiralOrder(int[][] matrix) {
        int dir = 0;
        int row = matrix.length;
        if (row == 0) return new int[0];
        int col = matrix[0].length;
        int[] ans = new int[row * col];
        visited = new boolean[row][col];
        int x = 0, y = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[x][y];
            visited[x][y] = true;
            int nx = x + dirX[dir];
            int ny = y + dirY[dir];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
                x = x + dirX[dir];
                y = y + dirY[dir];
            }
        }
        return ans;
    }
}
