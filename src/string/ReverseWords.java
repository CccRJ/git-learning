package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 151 翻转字符串 空格隔开每个单词反转顺序
 * @author: ChaiRJ
 * @create: 2020-04-10 12:28
 **/
public class ReverseWords {
    public String reverseWords(String s){
        int len =s.length();
        if (len==0)return s;
        List<String> l =new ArrayList<>();
        int begin=0,end=0;
        for (int i = 0; i < len; i++) {
            if ((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' ')begin=i;
            if (s.charAt(i)!=' '&&(i==len-1||s.charAt(i+1)==' ')){
                end=i+1;
                l.add(s.substring(begin,end));
            }
        }
        if (l.size()==0)return "";
        StringBuffer sb=new StringBuffer();
        for (int i = l.size() - 1; i > 0; i--) {
            sb.append(l.get(i));
            sb.append(" ");
        }
        sb.append(l.get(0));
        return sb.toString();
    }
    public String reverseWords2(String s){
        //除去开头末尾的空白字符
        s=s.trim();
        //正则匹配连续空白字符做分隔符
        List<String> words= Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ",words);
    }

    public static void main(String[] args) {

        System.out.println(new ReverseWords().reverseWords(" "));
    }
}
