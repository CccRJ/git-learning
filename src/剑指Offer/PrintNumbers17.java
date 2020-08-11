package 剑指Offer;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * @author: ChaiRJ
 * @create: 2020-07-16 11:25
 **/
public class PrintNumbers17 {
    public int[] printNumbers(int n) {
        int len = (int)Math.pow(10,n) - 1;
        int[] ans = new int[len];
        for(int i = 0;i < len;i++){
            ans[i] = i+1;
        }
        return ans;
    }
}
