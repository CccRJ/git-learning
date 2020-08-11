package match.doubleWeek30;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 5446. 三次操作后最大值与最小值的最小差
 * @author: ChaiRJ
 * @create: 2020-07-11 22:55
 **/
public class MinDifference5446 {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if (len <= 3)return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            min = Math.min(min,nums[len-1-i]-nums[3-i]);
        }
        return min;
    }
}
