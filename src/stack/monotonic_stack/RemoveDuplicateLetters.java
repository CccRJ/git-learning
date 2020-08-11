package stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: Java_Learning
 * @description: 316 移除字符串重复字符，并保证字符串返回值，字典序最小
 * @author: ChaiRJ
 * @create: 2020-05-30 16:56
 **/
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s){
        Deque<Character> stack = new ArrayDeque<>();

        //记录结果中出现过的字符
        HashSet<Character> seen = new HashSet<>();

        //记录每个字符最后出现的位置
        HashMap<Character,Integer> last_occurrence=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i),i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);

            if (!seen.contains(c)){
                //当前字符不存在，可以插入
                //栈不空，栈顶字符大于当前字符，且栈顶字符在后面还有出现
                //栈顶元素弹出，且清除当前统计set记录
                while (!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                //记录出现字符，压栈
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
