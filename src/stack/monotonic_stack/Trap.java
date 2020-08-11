package stack.monotonic_stack;
import java.lang.Math.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Trap {
    /*
     * 42 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
     * 计算按此排列的柱子，下雨之后能接多少雨水。
     * */
    public static int trap(int[] height){
        /*
        * 暴力解，某点的存水量是左右两侧最大值中较小值和自己高度的差
        * 加入自己比较大小，是自己时存水为 0
        * */
        int len = height.length;
        int res = 0;
        if(len < 3)return 0;
        for (int i = 1; i < len - 1; i++) {
            int maxL = 0,maxR = 0;
            for (int j = i; j >= 0; j--) {
                maxL = Math.max(height[j],maxL);
            }
            for (int j = i; j < len; j++) {
                maxR = Math.max(height[j],maxR);
            }
            res += Math.min(maxL,maxR) - height[i];
        }
        return res;
    }
    public static int trap2(int[] height){
        /*
        * 动态编程
        * 用两个数组先存储左右两侧高值，代替原先嵌套
        * */
        int res = 0;
        int len = height.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];

        if(len < 3)return 0;
        maxL[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxL[i] = Math.max(height[i],maxL[i - 1]);
        }
        System.out.println(Arrays.toString(maxL));
        maxR[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i],maxR[i + 1]);
        }
        System.out.println(Arrays.toString(maxR));
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(maxL[i],maxR[i]) - height[i];
        }
        return res;
    }

    /**
     * 通过单调栈进行实现，单调递减栈
     * @param height
     * @return
     */
    public static int trap3(int[] height){
        int ans = 0;
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int low = height[stack.poll()];//弹出元素的高度为底
                if (stack.isEmpty()){//栈为空不能接水
                    continue;
                }
                //高是当前位置和底元素的前一个元素的较小值
                int high = Math.min(height[stack.peek()],height[i]);

                ans += (i-stack.peek()-1)*(high-low);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1,2}));
    }
}
