package array;

/**
 * @program: Java_Learning
 * @description: 1013 将数组分为三个相等部分
 * @author: ChaiRJ
 * @create: 2020-03-11 08:53
 **/
public class CanThreePartsEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int S = 0;//总和
        for (int i : A) {
            S += i;
        }

        for (int i = 0; i < len - 2; i++) {
            //第一部分增加，第二三部分重置
            sum1 += A[i];
            sum3 = S - sum1;
            sum2 = 0;
            for (int j = i + 1; j < len - 1; j++) {
                //第二部分从第三部分中取出
                sum2 += A[j];
                sum3 -= A[j];
                if (sum1 == sum2 && sum2 == sum3) return true;
            }
        }
        return false;
    }

    public static boolean canThreePartsEqualSum2(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int S = 0;//总和
        for (int i : A) {
            S += i;
        }
        int n = 0, sum = 0;
        for (int value : A) {
            sum += value;
            if (sum == S / 3) {
                n++;
                sum = 0;
            }
        }
        return n >= 3;
    }


    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum2(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}
