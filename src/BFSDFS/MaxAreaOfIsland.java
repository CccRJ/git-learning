package BFSDFS;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 695 岛屿最大面积 连续的1的最大面积
 * @author: ChaiRJ
 * @create: 2020-03-15 17:17
 **/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length ==0)return 0;
        int lr = grid.length, lc = grid[0].length;
        int res = 0;
        for (int i = 0; i < lr; i++) {
            for (int j = 0; j < lc; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        int lr = grid.length, lc = grid[0].length;
        if (r >= lr || r < 0 || c >= lc || c < 0 || grid[r][c] == '*' || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = '*';//浏览过
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {

    }
}
