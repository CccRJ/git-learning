package 剑指Offer;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @author: ChaiRJ
 * @create: 2020-07-16 11:39
 **/
public class Exchange21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 1 && left < right) left++;
            while (nums[right] % 2 == 0 && left < right) right--;
            if (left < right)
                swap(nums,left,right);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
