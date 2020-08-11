package match.week197;

/**
 * @program: Java_Learning
 * @description: 5460. 好数对的数目
 * @author: ChaiRJ
 * @create: 2020-07-12 10:30
 **/
public class NumIdenticalPairs5460 {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length, ans = 0;
        if (len == 1)return ans;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] == nums[j])ans++;
            }
        }
        return ans;
    }
}
