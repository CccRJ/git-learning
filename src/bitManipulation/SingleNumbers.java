package bitManipulation;

/**
 * @program: Java_Learning
 * @description: 面试题56-1 数组中数字出现的次数
 * @author: ChaiRJ
 * @create: 2020-04-28 16:49
 **/
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        //全部异或找到两个只有一个的数字的异或
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        //找到二进制为1的一位
        int div = 1;
        while ((div & res) == 0)
            div <<= 1;
        //同为1的数放一组，不同的放另一组
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) == 0)
                a ^= n;
            else
                b ^= n;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
