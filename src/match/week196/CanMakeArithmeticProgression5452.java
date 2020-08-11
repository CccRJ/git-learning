package match.week196;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 5452. 判断能否形成等差数列
 * @author: ChaiRJ
 * @create: 2020-07-05 14:08
 **/
public class CanMakeArithmeticProgression5452 {
    public boolean canMakeArithmeticProgression(int[] arr){
        Arrays.sort(arr);
        int dis = arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]-arr[i-1] != dis)return false;
        }
        return true;
    }
}
