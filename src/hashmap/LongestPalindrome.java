package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 409 用一串字母拼写出最长回文串
 * @author: ChaiRJ
 * @create: 2020-03-19 17:33
 **/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        //记录每个字母出现次数
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        //偶数直接加，奇数找最大值
        int res = 0;
        boolean addOdd = false;
        for (Integer value : map.values()) {
            if (value % 2 == 0) res += value;
            else {
                res += value - 1;//奇数少加一位
                addOdd = true;//是否加过奇数
            }
        }
        return addOdd ? res + 1 : res;
    }

    //直接用数组存次数即可
    public int longestPalindrome2(String s) {
        int count[] = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int i : count) {
            ans += i / 2 * 2;
            if (i % 2 == 1 && ans % 2 == 0)//有奇数且结果没加过1
                ans++;
        }
        return ans;
    }
}
