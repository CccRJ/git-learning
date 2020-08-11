package sort;

import java.util.Arrays;

public class SortColors {
    /*
    * 75 颜色分类
    * 三个数字排序，不能使用库函数
    * 原地算法
    * */
    public static void sortColors(int[] nums){
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]){
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
