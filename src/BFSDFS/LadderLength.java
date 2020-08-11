package BFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 127 单词接龙 从字典中找到两个单词之间转换的最短路径 每次只能改变一个单词
 * @author: ChaiRJ
 * @create: 2020-02-26 20:30
 **/
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int res = 1;
        int len = wordList.size();
        boolean[] used = new boolean[len];//使用情况

        boolean existed = false;
        for (String s : wordList) {
            if(s == endWord)existed = true;
        }
        if (!existed)return 0;

        while(beginWord != endWord){
            List<Integer> dif = dif(beginWord,endWord);//与结果的差值
            if(dif.get(dif.size() - 1) == 1){//与答案只差一个字母
                res++;
                break;
            }
            boolean find = false;
            //从不同的位开始找下一个单词
            for (int j = 0; j < wordList.size(); j++) {
                //朝着结果改变
                List<Integer> difEach = dif(wordList.get(j), beginWord);//与每一个单词的差值
                if (difEach.get(difEach.size() - 1) == 1 && wordList.get(j).charAt(difEach.get(0)) == endWord.charAt(difEach.get(0)) && !used[j]) {
                    beginWord = wordList.get(j);
                    res++;
                    used[j] = true;
                    find = true;
                    break;
                }
            }
            if(!find) {//没找到随便改变一位
                for (int j = 0; j < wordList.size(); j++) {
                    //随便改变一位
                    List<Integer> difEach = dif(wordList.get(j), beginWord);//与每一个单词的差值
                    if (difEach.get(difEach.size() - 1) == 1 && !used[j]) {
                        beginWord = wordList.get(j);
                        res++;
                        used[j] = true;
                        find = true;
                        break;
                    }
                }
            }
            if(!find)return 0;
        }

        return res;
    }
    private List<Integer> dif(String s1, String s2){//返回两个单词的不同字母数和一个索引值
        List<Integer> res = new ArrayList<>();
        int dif = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                dif++;
                res.add(i);
            }
        }
        res.add(dif);
        return res;
    }

    public static void main(String[] args) {
        LadderLength l = new LadderLength();
        List<String> word = new ArrayList<>();
        word.add("hot");
        word.add("dot");
        word.add("dog");
        word.add("lot");
        word.add("log");
        word.add("cog");
        System.out.println(word);
        System.out.println(l.ladderLength("hit","cog",word));
    }
}
