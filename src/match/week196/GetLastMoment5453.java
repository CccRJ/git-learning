package match.week196;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 5453. 所有蚂蚁掉下来前的最后一刻
 * @author: ChaiRJ
 * @create: 2020-07-05 13:50
 **/
public class GetLastMoment5453 {
    public static int getLastMoment(int n, int[] left, int[] right) {
        int lenL = left.length, lenR = right.length;
        Arrays.sort(left);
        Arrays.sort(right);
        if (lenL == 0 && lenR == 0) return 0;
        else if (lenL == 0) return n - right[0];
        else if (lenR == 0) return left[lenL - 1];
        else return Math.max(n - right[0], left[lenL - 1]);
    }

    public static void main(String[] args) {
        getLastMoment(20,new int[]{4,7,15},new int[]{9,3,13,10});
    }
}
