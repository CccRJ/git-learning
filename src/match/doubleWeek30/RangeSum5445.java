package match.doubleWeek30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Java_Learning
 * @description:
 * @author: ChaiRJ
 * @create: 2020-07-11 22:48
 **/
public class RangeSum5445 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        int ans = 0;
        for(int i = left-1;i<= right-1;i++){
            ans += list.get(i);
            ans %= 1000000007;
        }
        return ans;
    }
}
