package dynamic;

/**
 * @program: Java_Learning
 * @description: 63. 不同路径 II
 * @author: ChaiRJ
 * @create: 2020-07-06 22:06
 **/
public class UniquePathsWithObstacles63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0)return 0;
        int col = obstacleGrid[0].length;
        if (col == 0)return 1;
        int[][] dp = new int[row][col];
        boolean haveObstacles = false;
        //第一行第一列初始化，如果有石头则右侧，下侧均是不可达，为0
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) haveObstacles = true;
            dp[i][0] = haveObstacles ? 0 : 1;
        }
        haveObstacles = false;
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) haveObstacles = true;
            dp[0][i] = haveObstacles ? 0 : 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(new int[][]{}.length);
        //uniquePathsWithObstacles(new int[][]{{}});
    }
}
