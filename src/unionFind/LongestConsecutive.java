package unionFind;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 128 最长连续序列
 * @author: ChaiRJ
 * @create: 2020-03-03 22:58
 **/
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums){
        int len = nums.length;
        if (len == 0)return 0;
        Arrays.sort(nums);
        int temp = 1,max = 1;

        for (int i = 1; i < len; i++) {
            if(nums[i] - 1 == nums[i - 1]){
                temp ++;
                max = Math.max(temp,max);
            }
            else if (nums[i - 1] == nums[i]) continue;
            else{
                max = Math.max(temp,max);
                temp = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }
}
