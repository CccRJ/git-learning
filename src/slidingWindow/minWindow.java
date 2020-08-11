package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 76. 最小覆盖子串 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * @author: ChaiRJ
 * @create: 2020-06-04 22:57
 **/
public class minWindow {
    public String minWindow(String s,String t){
        Map<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            if (need.containsKey(tChar))need.put(tChar,need.get(tChar)+1);
            else need.put(tChar,1);
        }
        int left=0,right=0;
        //判断多少个key，value键值对符合需求数
        int valid = 0;
        //最小覆盖字串的起始索引和长度
        int start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            //移入窗口的字符
            char c = s.charAt(right++);

            //包含值进行操作
            if (need.containsKey(c)){
                //记录过直接加一
                if (window.containsKey(c))window.put(c,window.get(c)+1);
                else window.put(c,1);

                //窗口中的字符数和需求一样多，符合值加一
                if (need.get(c).equals(window.get(c))){
                    valid ++;
                }
            }
            //判断是否需要缩进窗口左边缘
            while (valid == need.keySet().size()){
                //跟新最小字串
                if (right - left < len){
                    start = left;
                    len = right-left;
                }
                //移除窗口左侧元素
                char l = s.charAt(left++);
                //如果目标值中有这个字符进行操作
                if (need.containsKey(l)){
                    //window中字符数和需求一样多，但是需要减，此时有效值减一
                    if (need.get(l).equals(window.get(l))){
                        valid--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        new minWindow().minWindow("aa","aa");
    }
}
