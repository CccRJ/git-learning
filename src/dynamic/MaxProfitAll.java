package dynamic;

import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 所有的股票交易题
 * @author: ChaiRJ
 * @create: 2020-06-05 00:24
 **/
public class MaxProfitAll {
    /**
     * 121 一次交易股票，最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 多次买卖 k等于正无穷
     *
     * @param prices
     * @return
     */
    public int maxProfitK(int[] prices) {
        int len = prices.length;

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    /**
     * 最多两笔交易
     * dp--第i天，进行了k次交易，手中有无股票时的收益
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len==0)return 0;


        int maxK=2;
        int[][][] dp = new int[len][maxK+1][2];
        for (int i = 0; i < len; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][maxK][0];
    }


}
