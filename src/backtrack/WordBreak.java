package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Java_Learning
 * @description: 140 单词拆分II
 * @author: ChaiRJ
 * @create: 2020-03-07 20:37
 **/
public class WordBreak {
    private List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s,List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        backtrack(s,0,new StringBuffer(),set);
        return res;
    }
    public void backtrack(String s, int start, StringBuffer sb, Set<String> wordDict){
        if (start == s.length()){
            res.add(sb.toString());
            return;
        }
        else {
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start,end))) {
                    int len = sb.length();//保存长度
                    if(start != 0)sb.append(" ");
                    sb.append(s.substring(start, end));
                    backtrack(s, end, sb, wordDict);
                    //回溯
                    //sb传入函数后值发生改变
                    //sb = new StringBuffer(sb.substring(0, sb.lastIndexOf(" ")));
                    sb = new StringBuffer(sb.substring(0,len));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(){{
            add("and");
            add("cats");
            add("cat");
            add("sand");
            add("dog");
        }};
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak("catsanddog",l));
    }
}
