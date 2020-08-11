package array;

import java.util.Arrays;

public class PlusOne {
    /*
    * 数组保存一个整数，给这个数加一
    * 考虑满10进1
    * */
    public static int[] plusOne(int[] digits){
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if(digits[i] == 9)digits[i] = 0;
            else{
                digits[i]++;
                break;
            }
        }
        if(digits[0] == 0){//首位位0说明数组长度需要加一
            int[] res = new int[len + 1];
            Arrays.fill(res,0);
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
