import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    public static boolean isValid1(String s){
        /*
        * 判断是否是正确的括号顺序
        * */
        if(s.length()==0)return true;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        char top;//接收栈顶字符
        char c;
        boolean res = true;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            switch (c){//做括号存入
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                default:
                    if(stack.empty())return false;
                    top = stack.pop();
                    switch (c) {
                        case ')':
                            if (top != '(') return false;
                            break;
                        case '}':
                            if (top != '{') return false;
                            break;
                        case ']':
                            if (top != '[') return false;
                            break;
                    }
            }
        }
        if(!stack.empty())return false;//栈中还留有左括号
        return res;
    }
    public static boolean isValid2(String s){
        /*
        * leecode map实现
        * */
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){//右括号
                //栈空没有左括号
                if(stack.empty())return false;
                //左括号不匹配
                if(map.get(c) == stack.peek())stack.pop();
                else return false;
            }
            else{
                //左括号压栈
                stack.push(c);
            }
        }
        //栈空则全部配对成功， 否则返回失败
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid2("{{}}"));
    }
}
