package array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum1(int[] nums){//自己写的没过
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 3 || nums == null)return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i-1]){//通过当前指针和前一个进行比较而不是和后一个比较
                continue;
            }
            for (int j = i+1; j < len; j++) {
                for (int k = len-1; k > j+1; k--) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum < 0)break;
                    if(sum == 0){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        break;//得到k值没必要继续向后 遍历
                    }
                }
                while(j < len-2 && nums[j] == nums[j+1])j++;//直到与前面的j不同
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len <3) return ans;//空 长度不够
        Arrays.sort(nums);//排序
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) break;//当前数字大于0 三数和必大于零
            if(i > 0 && nums[i-1] == nums[i]){//去重,通过范围避免指针超出范围
                continue;
            }
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum =  nums[i] + nums[left] + nums[right];
                if(sum == 0){//存储结果更新左右指针
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left] == nums[left+1])left++;//去重
                    while(left<right && nums[right] == nums[right-1])right--;//去重
                    left++;
                    right--;
                }
                else if(sum < 0)left++;
                else if(sum > 0)right--;
    }
}
        return ans;
    }
}
