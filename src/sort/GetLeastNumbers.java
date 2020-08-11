package sort;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 面试题40 最小k个数
 * @author: ChaiRJ
 * @create: 2020-03-20 16:24
 **/
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
