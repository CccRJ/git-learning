package dynamic;

import java.util.List;

/**
 * @program: Java_Learning
 * @description: 120. 三角形最小路径和
 * @author: ChaiRJ
 * @create: 2020-07-14 10:09
 **/
public class MinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        //dp表示到达i，j这个位置的最小距离
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            //每行第一位只能通过上一层第一位得到
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            //每行最后一位只能通过上一行最后一位的到
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[size - 1][0];
        for (int i = 0; i < size; i++) {
            min = Math.min(min, dp[size - 1][i]);
        }
        return min;
    }

    /**
     * @Description: 压缩空间
     * @Param: [triangle]
     * @return: int
     * @Author: ChaiRJ
     * @Date: 2020/7/14
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int i : dp) {
            min = Math.min(i, min);
        }
        return min;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int size = triangle.size();
        for (int i = 1; i < size; i++) {
            triangle.get(i).add(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < i; j++) {
                triangle.get(i).add(j,
                        Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j))
                                + triangle.get(i).get(j));
            }
            triangle.get(i).add(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
        }
        int min = triangle.get(size - 1).get(0);
        for (Integer i : triangle.get(size - 1)) {
            min = Math.min(i, min);
        }
        return min;
    }
}
