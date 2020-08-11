package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 面试57 - II. 和为s的连续正整数序列
 * @author: ChaiRJ
 * @create: 2020-03-06 15:18
 **/
public class FindContinuousSequence {
    public static int[][] findContinuousSequence(int target){
        if(target < 3)return null;

        List<int[]> res = new ArrayList<>();
        int num = 2;
        while ((double)(target / num) >= (double) (num / 2)){//左侧有足够的值
            int temp = 0;
            if(num % 2 == 0 && target % num != 0){//需要偶数个值 不能相等
                temp = (2 * (target / num) + 1) * (num / 2);
                if (temp == target){
                    int[] ans = new int[num];
                    int n = target / num - num / 2 + 1;
                    if (n <= 0){//结果是正数
                        num ++ ;
                        continue;
                    }
                    for (int i = 0; i < num; i++) {
                        ans[i] = n++;
                    }
                    res.add(ans);
                }
            }
            else if (num % 2 == 1 && target % num == 0){//奇数个值 除后相等
                int[] ans = new int[num];
                int n = target / num - num / 2;
                if (n <= 0){//结果是正数
                    num ++ ;
                    continue;
                }
                for (int i = 0; i < num; i++) {
                    ans[i] = n++;
                }
                res.add(ans);
            }
            num++;
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(res.size() - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
}
