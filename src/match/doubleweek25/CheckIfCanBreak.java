package match.doubleweek25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 5386 检查一个字符串 是否可以打破另一个字符串
 * @author: ChaiRJ
 * @create: 2020-05-02 23:12
 **/
public class CheckIfCanBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        //匹配问题
        int len=s1.length();
        boolean[] b=new boolean[len];
        List<List<Character>> res1=new ArrayList<>();
        backtrack(s1,0,len,new boolean[len],res1,new ArrayList<Character>());
        List<List<Character>> res2=new ArrayList<>();
        backtrack(s2,0,len,new boolean[len],res2,new ArrayList<Character>());
        boolean res=compare(res1,res2);
        if (res)return true;
        else res=compare(res2,res1);
        return res;
    }

    private void backtrack(String s,int curLen,int len,boolean[] visited, List<List<Character>> res,List<Character> tmp){
        if (curLen==len){
            res.add(new ArrayList<>(tmp));
            return;
        }
        else{
            for (int i = 0; i < len; i++) {
                if (!visited[i]){
                    visited[i]=true;
                    tmp.add(s.charAt(i));
                    backtrack(s,curLen+1,len,visited,res,tmp);
                    tmp.remove(tmp.size()-1);
                    visited[i]=false;
                }
            }
        }
    }

    private boolean compare(List<List<Character>> l1,List<List<Character>> l2){
        boolean res;
        for (List<Character> left : l1) {
            for (List<Character> right : l2) {
                res=true;
                for (int i = 0; i < right.size(); i++) {
                    if (left.get(i)<right.get(i)){
                        res=false;
                        break;
                    }
                }
                if (res)return true;
            }
        }
        return false;
    }
    public boolean checkIfCanBreak2(String s1,String s2){
        int len=s1.length();
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int flag=0;
        for (int i = 0; i < len; i++) {
            if (c1[i]==c2[i])continue;
            else if (flag==0)flag=c1[i]>c2[i]?1:-1;
            else if (flag>0 && c1[i]<c2[i])return false;
            else if (flag<0 && c1[i]>c2[i])return false;
        }
        return true;
    }
    public static void main(String[] args) {
        new CheckIfCanBreak().checkIfCanBreak2("abe","acd");
    }
}
