package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 1160 拼写单词 用字母表拼写词汇表
 * @author: ChaiRJ
 * @create: 2020-03-17 08:29
 **/
public class CountCharacters {
    public int countCharacters(String[] words,String chars){
        int res =0;
        if (words.length == 0)return 0;
        Map<Character,Integer> map = new HashMap<>();
        //把每个字母出现次数记录
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        //拼写单词，能拼出来字母数减一
        for (String word : words) {
            Map<Character,Integer> temp = new HashMap<>(map);
            int i;
            for (i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(temp.containsKey(c)){
                    if (temp.get(c)-1>0)
                        temp.put(c,temp.get(c)-1);
                    else
                        temp.remove(c);

                }else {
                    break;
                }
            }
            if (i==word.length()){
                res+=i;
            }
        }
        return res;
    }
}
