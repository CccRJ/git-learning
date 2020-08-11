package stack;

import java.util.Stack;

/**
 * @program: Java_Learning
 * @description: 150 计算后缀表达式
 * @author: ChaiRJ
 * @create: 2020-03-18 22:38
 **/
public class EvalRPN {
    public int evalRPN(String[] tokens){
        int len = tokens.length;
        if (len == 0)return 0;

        Stack<Integer> s = new Stack<>();
        for (String c : tokens) {
            if (c.length()!=1){
                s.push(Integer.parseInt(String.valueOf(c)));
                continue;
            }
            char n = c.charAt(0);
            if (n>='0'&&n<='9'){
                s.push(Integer.parseInt(String.valueOf(c)));
            }
            else if (c.equals("+"))
                s.push(s.pop()+s.pop());
            else if (c.equals("-"))
                s.push(-(s.pop()-s.pop()));
            else if (c.equals("*"))
                s.push(s.pop()*s.pop());
            else{
                int temp = s.pop();
                s.push(s.pop()/temp);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvalRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
