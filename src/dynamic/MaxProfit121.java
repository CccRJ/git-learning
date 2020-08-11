package dynamic;

/**
 * @program: Java_Learning
 * @description: 121 买卖股票最佳时机
 * @author: ChaiRJ
 * @create: 2020-02-22 16:11
 **/
public class MaxProfit121 {
    public static int maxProfit(int[] prices){
        int len = prices.length;
        int res = 0;
        if(len == 0)return res;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res,prices[j] - prices[i]);
            }
        }
        return Math.max(res, 0);
    }

    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price,minPrice);
            maxProfit = Math.max(maxProfit,price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,5,4,4,1}));
    }
}
