package match.week197;

/**
 * @program: Java_Learning
 * @description: 5461. 仅含 1 的子串数
 * @author: ChaiRJ
 * @create: 2020-07-12 10:34
 **/
public class NumSub5461 {
    public int numSub(String s) {
        int len = s.length();
        long ans = 0;
        long count = 0;//为啥它也是long
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='1')count++;
            if(s.charAt(i)=='0' || i==len-1){
                ans += ((1+count)*count/2);
                ans %= 1000000007;
                count = 0;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println((long)(1+100000)*100000/2);
    }
}
