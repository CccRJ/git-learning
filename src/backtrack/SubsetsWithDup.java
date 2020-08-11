package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    /*
    * 90 子集2
    * 包含重复元素，结果不能包含重复集
    * */
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,res,new ArrayList<Integer>());
        return res;
    }
    private void backtrack(int[] nums,int start,List<List<Integer>> res,List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //不是开始第一个数字，而且和前一个数字相等，跳过这个数字，避免出现重复
            if(i > start && nums[i] == nums[i - 1])continue;
            temp.add(nums[i]);
            backtrack(nums,i + 1,res,temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }
}

