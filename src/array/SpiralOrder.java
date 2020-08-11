package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 59 螺旋矩阵I，II
 */
public class SpiralOrder {
    /*
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
     * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int lenRow = matrix.length, lenCol = matrix[0].length;
        boolean seen[][] = new boolean[lenRow][lenCol];
        //四个方向
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < lenRow * lenCol; i++) {
            res.add(matrix[r][c]);
            seen[r][c] = true;
            int rr = r + dr[di];
            int cc = c + dc[di];
            if (rr >= 0 && rr < lenRow && cc >= 0 && cc < lenCol && !seen[rr][cc]) {
                r = rr;
                c = cc;
            } else {//这个方向的下一个位置不合法,改方向
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return ans;
        int cols = matrix[0].length;
        boolean[][] printed = new boolean[rows][cols];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0, dir = 0;
        for (int i = 0; i < rows * cols; i++) {
            ans.add(matrix[r][c]);
            printed[r][c] = true;
            int newR = r + dr[dir];
            int newC = c + dc[dir];
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !printed[newR][newC]) {
                r = newR;
                c = newC;
            } else {
                dir = (dir + 1) % 4;
                r = r + dr[dir];
                c = c + dc[dir];
            }
        }
        return ans;
    }

    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] printed = new boolean[n][n];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, dir = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[r][c] = i;
            printed[r][c] = true;

            int newR = r + dr[dir];
            int newC = c + dc[dir];
            if (newR >= 0 && newR < n && newC >= 0 && newC < n && !printed[newR][newC]) {
                r = newR;
                c = newC;
            } else {
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
        System.out.println(so.spiralOrder2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
