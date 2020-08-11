package dynamic;

import java.util.*;

/**
 * @program: Java_Learning
 * @description: 139 单词拆分，用字典中的单词能否拼成 目标字符串
 * @author: ChaiRJ
 * @create: 2020-03-06 16:13
 **/
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> dict) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;//字典单词长度
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (String d : dict) {
            min = Math.min(d.length(), min);
            max = Math.max(d.length(), max);
        }
        for (String w : dict) {
            int len = w.length();
            if (map.containsKey(len)) {//存在这个长度的map直接加入
                map.get(len).put(w, 1);
            } else {//不存在，创建map并加入
                map.put(len, new HashMap<>() {{
                    put(w, 1);
                }});
            }
        }
        return dynamic(s, map, max, min);
    }

    private boolean dynamic(String s, Map<Integer, Map<String, Integer>> map, int max, int min) {
        if (s.length() == 0) return true;//刚好等于0证明全部匹配
        if (s.length() < min) return false;//长度不够进行匹配则失败

        for (Integer i : map.keySet()) {
            //包含匹配的单词，把剩余部分进行迭代
            if (map.containsKey(i) && s.length() >= i && map.get(i).containsKey(s.substring(0, i)))
                if (dynamic(s.substring(i), map, max, min))
                    return true;
        }
        return false;
    }
    /** 
    * @Description: 宽度优先搜索，使用队列，判断是否能实现即可
    * @Param: [s, dict] 
    * @return: boolean 
    * @Author: ChaiRJ
    * @Date: 2020/3/7 
    */ 
    public boolean wordBreak2(String s, List<String> dict) {
        Set<String> dictSet = new HashSet<>(dict);//用hashset实现直接提取
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];//是否访问过这个位置
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.remove();
            if (!visited[start]) {//没访问过，从这个位置开始向后查询
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dictSet.contains(s.substring(start, end))) {
                        q.add(end);
                        if (end == s.length()) return true;
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak139 w = new WordBreak139();
        System.out.println(w.wordBreak("catsandog", new ArrayList<>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }}));
    }
}
