package dynamic;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/**
 * 62 左上角到右下角多少条路径
 */
public class UniquePaths62 {
    /*
    * m * n 的网格中从左上角到右下角又多少条路径
    * 每次只能向右或者向下
    * */
    public int res = 0;
    private int m;
    public int n;
    public int uniquePaths(int m,int n){
        this.m = m;
        this.n = n;

        path(1,1);
        return res;
    }
    private void path(int x,int y){
        if(x == m && y == n){
            res ++;
            return;
        }
        if(x > m || y > n)return;
        path(x + 1,y);
        path(x,y + 1);
    }
    public int uniquePaths2(int m,int n){
        /*
        * 动态规划 时间复杂度O（M*N） 空间复杂度O（M*N）
        * */
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths3(int m,int n){
        /*
        * 动态规划优化 时间复杂度O（M*N） 空间复杂度O（n）
        * */
        int[] res = new int[n];
        Arrays.fill(res,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
//        UniquePaths62 u = new UniquePaths62();
//        System.out.println(u.uniquePaths3(7,3));
        System.out.println(UniquePaths62.class.getClassLoader());
        System.out.println(UniquePaths62.class.getClassLoader().getParent());
        System.out.println(UniquePaths62.class.getClassLoader().getParent().getParent());
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        int len = nums1.length+nums2.length;
        if(len == 0)return 0.0;
        int x=0,y=0;
        int[] ans = new int[len];
        if(nums1.length==0)return len%2==0?(nums2[len/2]+nums2[len/2-1]) / 2.0 : nums2[len/2];
        if(nums2.length==0)return len%2==0?(nums1[len/2]+nums1[len/2-1]) / 2.0 : nums1[len/2];

        for(int i = 0;i <= len/2; i++){
            if(x < nums1.length && nums1[x]<=nums2[y]){
                ans[i]=nums1[x];
                x++;
            }else{
                ans[i] = nums2[y];
                y++;
            }
        }
        return len%2==0?(ans[len/2]+ans[len/2-1]) / 2.0 : ans[len/2];
    }
}
