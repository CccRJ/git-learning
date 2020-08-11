package backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    /*
    * 78 子集
    * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
    * 回溯
    * */
    public  List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res,new ArrayList<Integer>());
        return res;
    }
    private void backtrack(int[] nums,int start,List<List<Integer>> res,List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums,i + 1,res,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
