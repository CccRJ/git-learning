package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 567 检查前一个串是否有后一个串的排列
 * @author: ChaiRJ
 * @create: 2020-06-04 23:48
 **/
public class CheckInclusion {
    public static boolean checkInclusion(String s,String t){
        Map<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            if (need.containsKey(tChar))need.put(tChar,need.get(tChar)+1);
            else need.put(tChar,1);
        }
        int left=0,right=0;
        int valid = 0;
        while (right < s.length()){
            char r = s.charAt(right++);

            //包含值进行操作
            if (need.containsKey(r)){
                //记录过直接加一
                if (window.containsKey(r))window.put(r,window.get(r)+1);
                else window.put(r,1);

                //窗口中的字符数和需求一样多，符合值加一
                if (need.get(r).equals(window.get(r))){
                    valid ++;
                }
            }
            while (right-left >= t.length()){
                if (valid == need.size()){
                    return true;
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
        return false;
    }

    public static void main(String[] args) {

    }
}
