package dynamic;

/**
 * @program: Java_Learning
 * @description: k数之和，
 *               给定 n 个不同的正整数，整数 k（k <= n）以及一个目标数字 target。　
 *               在这 n 个数里面找出 k 个数，使得这 k 个数的和等于目标数字，求问有多少种方案？
 * @author: ChaiRJ
 * @create: 2020-06-05 10:33
 **/
public class KSum{
    public static int kSum(int[] A,int k,int target){
        int len = A.length;
        if (A == null || len == 0 || k <= 0)return 0;
        //当前 i 个数，其中k个数的和 是 target
        int[][][] dp = new int[len+1][k+1][target+1];

        //目标值是0，方案为1
        for (int i = 0; i <= len; i++) {
            dp[i][0][0] = 1;
        }
        //f[i][j][t] = f[i - 1][j][t] + f[i - 1][j - 1][t -A[i]]
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    //没有加操作的前一个数的方案
                    dp[i][j][t] = dp[i-1][j][t];
                    //目标值减前一个值大于0，可以加
                    //前一个数，的少加一个数，值是：当前t 减去 前一个数（i-1）的值
                    dp[i][j][t] += t - A[i-1] >=0? dp[i-1][j-1][t-A[i-1]]:0;
                }
            }
        }
        return dp[len][k][target];
    }

    public static void main(String[] args) {
        System.out.println(kSum(new int[]{1,2,3,4,5},3,6));
    }
}

