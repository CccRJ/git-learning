package greedy;

/**
 * @program: Java_Learning
 * @description: 45.跳跃游戏II
 * @author: ChaiRJ
 * @create: 2020-05-05 14:14
 **/
public class JumpII {
    public int jump(int[] nums) {
        int count = 0;
        int max, maxStep;
        int len = nums.length;
        if (len <= 1) return 0;
        int place = 0;
        while (place < len - 1) {
            max = 0;
            maxStep = -1;
            for (int i = 1; i <= nums[place]; i++) {
                //到达终点直接结束
                if (place + i >= len - 1) {
                    count++;
                    place = len - 1;
                    break;
                }
                //找到当前一步 加下一步最大距离
                if (i + nums[place + i] > max) {
                    max = i + nums[place + i];
                    maxStep = i;
                }
            }
            if (place != len - 1) {
                place += maxStep;
                count++;
            }
        }
        return count;
    }

    //答案
    public int jumpII(int[] nums) {
        int len = nums.length;
        int end = 0;//当前位置
        int maxPos = 0;//当前位置之前所有点，可以到达的最远位置
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            //比较当前i 所到最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {//到达当前节点，跟新为最远位置
                end = maxPos;
                count++;
            }
        }
        return count;
    }
}
