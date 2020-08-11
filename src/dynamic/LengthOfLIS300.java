package dynamic;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 300 最长上升子序列
 * @author: ChaiRJ
 * @create: 2020-03-14 10:52
 **/
public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int res = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        //贪心算法,找到大于当前值的最小数
        int len = nums.length;
        if (len == 0) return 0;
        int max = 1;
        int[] dp = new int[len + 1];
        dp[max] = nums[0];//初始化
        for (int i = 1; i < len; i++) {//比最后一个数大，直接添加
            if (nums[i] > dp[max]) {
                dp[++max] = nums[i];
            } else {//找到第一个小于自己的数 二分查找
                int left = 1, right = max, pos = 0;//所有数都比num[i]大 更改第一个数
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] < nums[i] && dp[mid + 1] >= nums[i]) {
                        pos = mid;
                        break;
                    }
                    if (dp[mid] < nums[i]) left = mid + 1;
                    else right = mid - 1;
                }
                dp[pos + 1] = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS300().lengthOfLIS2(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }
}
