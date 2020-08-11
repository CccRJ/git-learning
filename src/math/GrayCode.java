package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 89 格雷编码
 * @author: ChaiRJ
 * @create: 2020-06-22 17:10
 **/
public class GrayCode {
    public List<Integer> grayCode(int n){
        List<Integer> ans = new ArrayList<>(){{add(0);}};

        int head = 1;
        for (int i = 0; i < n; i++) {
            //从后向前取出，并且在首位加1
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head+ans.get(j));
            }
            //多一阶，head左移一位
            head <<= 1;
        }
        return ans;
    }
}
