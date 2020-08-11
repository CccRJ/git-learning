package dynamic;

public class MaxSubArray {
    /*
    * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
    * （子数组最少包含一个元素），返回其最大和。
    * 动态规划
    * */
    public static int maxSubArray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0)
                sum += num;
            else
                sum = num;
            ans = Math.max(sum,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
