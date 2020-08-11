package dynamic;

/**
 * @program: Java_Learning
 * @description: 983.最低票价
 * @author: ChaiRJ
 * @create: 2020-05-06 12:35
 **/
public class MincostTickets983 {
    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int len = days.length;
        int i, j = 0;
        for (i = 1; i <= 365; i++) {
            //不是旅行日，价钱等于前一天
            if (i != days[j]) {
                dp[i] = dp[i - 1];
            } else {//比较前一天 前七天 前一月 的价格找最小值
                int cost1 = dp[i - 1] + costs[0];
                int cost7,cost30;
                int min = cost1;
                if (i >= 7) {
                    cost7 = dp[i - 7] + costs[1];
                }else cost7=costs[1];//不够七天也可以买七天的票
                min = Math.min(min, cost7);
                if (i >= 30) {
                    cost30 = dp[i - 30] + costs[2];
                }else cost30=costs[2];
                min = Math.min(min, cost30);
                dp[i] = min;
                j++;
                if (j == days.length) break;
            }
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20},new int[]{7,2,15}));
    }
}
