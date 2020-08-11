import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/*
* 给出n对括号能组成的所有有效组合
* */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
    public static List<String> generateParenthesis(int n){
        /*
        * 动态规划，第n次的结果可以由前面第p次结果和第q次结果加上一对括号生成
        * p + q = n - 1
        * p在括号中 q在括号外
        * res 的没一个位置上都是，第n次的所有结果
        * */
        List<List<String>> res = new ArrayList<>();
        if(n == 0)return res.get(0);
        //生成第0次和第1次的结果,加入结果数组
        List<String> l1 = new ArrayList<>();
        l1.add("");
        res.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("()");
        res.add(l2);

        //生成2之后的结果
        for (int i = 2; i <= n; i++) {//组合现有的括号从2到n对
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                //一共i - 1 对括号，组成res的第i个结果。j对放里面，i - 1 - j 对放外面
                List<String> strIn = res.get(j);//放在第n对括号内
                List<String> strOut = res.get((i - 1) - j);//放在第n对括号外
                for (String in : strIn) {
                    for (String out : strOut) {
                        temp.add("(" + in + ")" + out);//组合
                    }
                }
            }
            res.add(temp);
        }
        return res.get(n);//返回n对括号结果
    }
}
