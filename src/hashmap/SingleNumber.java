package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 136 只出现一次的数字
 * @author: ChaiRJ
 * @create: 2020-03-04 17:26
 **/
public class SingleNumber {
    public int singleNumber(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i += 2) {
            if (i == len - 1)return nums[i];
            if(nums[i] == nums[i + 1])continue;
            else return nums[i];
        }
        return 0;
    }
    public int singleNumber2(int[] nums){
        Map<Integer,Integer> map= new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.remove(num);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }
        return 0;
    }
    public int singleNumber3(int[] nums){
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber3(new int[]{1,4,2,2,1}));
    }
}
