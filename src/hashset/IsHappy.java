package hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Java_Learning
 * @description: 202 快乐数
 * @author: ChaiRJ
 * @create: 2020-04-30 19:11
 **/
public class IsHappy {
    //每一位平方求和
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

    //一直循环，能否最终结果为1
    public boolean isHappy(int n) {
        Set<Integer> circle = new HashSet<>();
        int next = getNext(n);
        while (next != 1) {
            circle.add(next);
            if (circle.contains(next))
                return false;
            next=getNext(next);
        }
        return true;
    }
}
