package dynamic;

/**
 * @program: Java_Learning
 * @description: 122 买卖股票最佳时机 多次买卖
 * @author: ChaiRJ
 * @create: 2020-02-22 16:41
 **/
public class MaxProfit122 {
    public static int maxProfit(int[] prices){
        int res = 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
                if(i + 1 < len && prices[i + 1] <= prices[i]){
                    //在极大值点保证卖出
                    res += maxProfit;
                    maxProfit = 0;
                    minPrice = prices[i + 1];
                }
                if(i == len - 1)
                    res += maxProfit;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,5,4,3}));
    }
}
