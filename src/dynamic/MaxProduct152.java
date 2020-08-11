package dynamic;

/**
 * @program: Java_Learning
 * @description: 152 乘积最大连续子数列
 * @author: ChaiRJ
 * @create: 2020-03-19 19:00
 **/
public class MaxProduct152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, tMax = 1, tMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = tMax;
                tMax = tMin;
                tMin = temp;
            }
            tMax = Math.max(tMax * nums[i], nums[i]);
            tMin = Math.min(tMin * nums[i], nums[i]);
            max = Math.max(max, tMax);
        }
        return max;
    }
}
