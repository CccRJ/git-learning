package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 131 分割回文串 分割字符串使所有子串都是回文串并返回所有答案
 * @author: ChaiRJ
 * @create: 2020-03-04 16:36
 **/
public class Partition {
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s){
        if (s.length() == 0)return res;
        backtrack(s,0,new ArrayList<>());

        return res;
    }

    public void backtrack(String s,int start,List<String> temp){
        if (start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        else {
            for (int i = 1; i <= s.length() - start; i++) {
                //substring左闭右开
                String subString = s.substring(start,start + i);
                if (isHuiWen(subString)){
                    temp.add(subString);
                    backtrack(s,start + i,temp);

                    //回溯
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isHuiWen(String s){
        //判断是否是回文串
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if(s.charAt(i) == s.charAt(len - i - 1))continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.partition("ababab"));
    }
}
