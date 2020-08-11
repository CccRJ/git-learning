package dynamic;

public class NumDecodings91 {
    /*
    * 91 解码方法 动态规划
    * 给一串数字，能解码处多少种字母排列
    * */

    private int res = 1;
    public int numDecodings(String s){
        //判空
        if(s.length() == 0 || s.charAt(0) == '0')return 0;

        subString(s,0);
        return res;
    }
    private void subString(String s,int n){
        //超出范围结束
        if(n > s.length() - 1)return;

        //0开头 排除(特殊情况)
        int x = Character.getNumericValue(s.charAt(n));
        if(x == 0){
            res--;
            return;
        }
        //最后一位结束
        if(n == s.length() - 1)return;

        int y = Integer.parseInt(String.valueOf(s.charAt(n + 1)));

        if(x > 2 || x == 2 && y > 6){
            //超出范围只能继续下一位
            subString(s,n + 1);
        }
        else{
            //符合条件后，多出一种编码方式
            res++;
            subString(s,n + 1);
            subString(s,n + 2);
        }
    }

    public static void main(String[] args) {
        NumDecodings91 n = new NumDecodings91();
        System.out.println(n.numDecodings("1"));
    }
}
