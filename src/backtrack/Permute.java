package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute {
    /*
    * 46全排列
    * 给定一个没有重复数字的序列，返回其所有可能的全排列。
    * */
    private int len;
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    private void generatePermutation(Stack<Integer> temp,boolean[] visited,int curLen){
        if(curLen == len){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!visited[i]){
                visited[i] = true;
                temp.push(nums[i]);
                generatePermutation(temp,visited,curLen + 1);
                //回溯必须重置状态数组
                temp.pop();
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        if(len == 0)return res;

        this.len = len;
        this.nums = nums;
        generatePermutation(new Stack<Integer>(),new boolean[len],0);

        return res;
    }
    public static void main(String[] args) {
        Permute p = new Permute();

        System.out.println(p.permute(new int[]{1,2,3}));
    }
}
