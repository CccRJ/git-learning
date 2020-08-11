package array;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 169 多数元素 占整个数组一半以上的元素
 * @author: ChaiRJ
 * @create: 2020-03-13 10:31
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int num = 1;
        for (int n = 1; n < nums.length; n++) {
            if (nums[n] == nums[n - 1]) {
                num++;
                if (num > nums.length / 2) return nums[n];
            } else {
                num = 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,2,1,1,1,2}));
    }
}
