package match.week187;

/**
 * @program: Java_Learning
 * @description: 5402. 绝对差不超过限制的最长连续子数组
 * @author: ChaiRJ
 * @create: 2020-05-03 10:50
 **/
public class LongestSubarray {
    public static int longestSubarray(int[] nums, int limit) {
        //超时
//        int max=-1;
//        int count=0;
//        int begin=0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = begin; j <=i; j++) {
//                if (Math.abs(nums[j]-nums[i])>limit){
//                    count=count-(j-begin+1);
//                    begin=j+1;
//                }
//            }
//            count+=1;
//            max=Math.max(max,count);
//        }
//        return max;

        int max=1;
        int left=nums[0],right=nums[0];
        int begin=0;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>=nums[i-1] && nums[i]-left <=limit){
                count++;
                max=Math.max(max,count);
                left=Math.min(left,nums[i]);
                right=Math.max(right,nums[i]);
                continue;
            }
            if (nums[i]<nums[i-1] && right-nums[i]<=limit){
                count++;
                max=Math.max(max,count);
                left=Math.min(left,nums[i]);
                right=Math.max(right,nums[i]);
                continue;
            }
            for (int j = begin; j <=i; j++) {
                if (Math.abs(nums[j]-nums[i])>limit){
                    count=count-(j-begin+1);
                    begin=j+1;
                    left=Integer.MAX_VALUE;
                    right=-1;
                }
                else{
                    left=Math.min(left,nums[j]);
                    right=Math.max(right,nums[j]);
                }
            }
            count+=1;
            max=Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{4,8,5,1,7,9},6));
    }
}
