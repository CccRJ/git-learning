package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    //全局变量 用this.变量名赋值
    private int len;
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;

    public void findCombinationSum(int residue,int start,Stack<Integer> pre){
        //如果此时结果是0，将栈中的元素导入字符串
        if(residue == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        //剩余值还大于0进入循环
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            //从当前i值向后，因为可以选择重复，避免从小从头开始选择出现重复答案
            findCombinationSum(residue - candidates[i],i,pre);
            pre.pop();//避免了栈的深度过深
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        int len = candidates.length;
        if(len == 0)return res;

        Arrays.sort(candidates);//排序

        //全局变量赋值
        this.len = len;
        this.candidates = candidates;
        //传入栈用于存储
        findCombinationSum(target,0,new Stack<>());

        return res;
    }
}
