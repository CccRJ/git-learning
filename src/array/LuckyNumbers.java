package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 5356  180周赛 矩阵中的幸运数 同行最小同列最大
 * @author: ChaiRJ
 * @create: 2020-03-15 18:32
 **/
public class LuckyNumbers {
    public List<Integer> luckNumber(int[][] matrix){
        if (matrix.length==0)return null;
        int lr = matrix.length,lc=matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[] minR = new int[lr],maxC=new int[lc];
        Arrays.fill(minR,Integer.MAX_VALUE);
        Arrays.fill(maxC,Integer.MIN_VALUE);

        for (int i = 0; i < lr; i++) {
            for (int j = 0; j < lc; j++) {
                minR[i] = Math.min(matrix[i][j],minR[i]);
                maxC[j] = Math.max(matrix[i][j],maxC[j]);
            }
        }
        for (int i = 0; i < lr; i++) {
            for (int j = 0; j < lc; j++) {
                if (matrix[i][j] == minR[i] &&matrix[i][j]==maxC[j])
                    res.add(matrix[i][j]);
            }
        }
        return res;
    }
}
