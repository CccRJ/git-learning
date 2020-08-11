package dynamic;

/**
 * @program: Java_Learning
 * @description: 221.最大正方形 （动态规划）
 * @author: ChaiRJ
 * @create: 2020-05-08 19:34
 **/
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;

                else if ((i == 0 || j == 0) && matrix[i][j] == '1') dp[i][j] = 1;
                else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
