package dynamic;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 322 零钱兑换
 * @author: ChaiRJ
 * @create: 2020-03-08 17:57
 **/
public class CoinChange322 {
    public static int coinChange(int[] coins,int amount){
        //自下而上 动态规划
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)continue;
                dp[i] = Math.min(dp[i],1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
    public int coinChange2(int[] coins,int amount){
        //自上而下 动态规划 使用备忘录 记录已经计算过的数字
        if (amount < 1) return 0;
        return dynamic(coins,amount,new int[amount]);
    }
    private int dynamic(int[] coins,int remain,int[] count){
        if (remain < 0)return -1;
        if (remain == 0)return 0;
        //备忘录 如果存在直接返回
        if (count[remain - 1] != 0)return count[remain - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dynamic(coins,remain - coin,count);
            if (res >= 0 && res < min)//有合适的值，找到其中最小的
                min = res + 1;
        }
        //没有找到任何合适的值 min还是最大值 返回-1，改变备忘录count中的值
        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));
    }
}
