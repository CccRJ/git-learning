import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(90000));
    }
    public static int reverse(int x){
        int res = 0;
        while(x != 0) {
            //取一位算一位
            int pop = x % 10;
            //判断结果是否超出int范围
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            x /= 10;
            res = res * 10 + pop;
        }
        return res;
    }
}
