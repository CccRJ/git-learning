package hashmap;

import java.util.*;

public class GroupAnagrams {
    /*
    * 给定一个字符串数组，将字母异位词组合在一起。
    * 字母异位词指字母相同，但排列不同的字符串。
    * */
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new ArrayList<>();

        if(strs.length == 0)return ans;
        //相同字母的字符串排序后是相同的，用排序后的字符串当作key创建map
        Map<String,List<String>> res = new HashMap<>();
        char[] tmp;
        for (String str : strs) {
            tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = Arrays.toString(tmp);//存排序后的key
            List<String> list;
            if(!res.containsKey(key))//不存在key，创建并添加
                res.put(key,new ArrayList<>(Arrays.asList(str)));
            else{//存在直接添加
                list = res.get(key);
                list.add(str);
                res.put(key,list);
            }
        }

        ans.addAll(res.values());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
