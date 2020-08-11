package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] target = ts.twoSum(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.print("Target: ");
        for (int i : target) {
            System.out.print(i + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        /*
         * 返回相加等于要求目标的 两个数的索引值
         * */
        Map<Integer, Integer> map = new HashMap<>();
        //将值存入key，索引存入value
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complements = target - nums[i];//需要的值
            //有需要的值，并且这个值不是当前值，避免重复
            if (map.containsKey(complements) && map.get(complements) != i) {
                return new int[]{i, map.get(complements)};
            }
        }
        throw new IllegalArgumentException();
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{};
        Arrays.sort(nums);
        int l = 0, r = len - 1;
        while (true) {
            int tmp = nums[l] + nums[r];
            if (tmp == target) {
                return new int[]{l, r};
            } else if (tmp > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
