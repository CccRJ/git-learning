package search;

import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int lRes,rRes;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){//找到结果向两侧查找
                lRes = mid;
                rRes = mid;
                while(lRes > 0 && nums[lRes-1] == nums[mid])lRes--;
                while(rRes < nums.length - 1 && nums[rRes+1] == nums[mid])rRes++;

                return new int[]{lRes,rRes};
            }
            if(target <= nums[mid])right = mid - 1;
            else left = mid + 1;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,7,8,8,9},7)));
    }
}
