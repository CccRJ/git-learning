package stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: Java_Learning
 * @description: 84 柱状图中最大的矩形
 * @author: ChaiRJ
 * @create: 2020-05-30 12:19
 **/
public class LargestRectangleArea {
    /**
     * 暴力解法，遍历每一个柱，找到向两侧扩散的最大值
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        int max = 0;
        int l, r;
        for (int i = 0; i < len; i++) {
            for (l = i; l >= 0 && heights[l] >= heights[i]; l--) ;
            for (r = i; r < len && heights[r] >= heights[i]; r++) ;
            max = Math.max(max, (r - l - 1) * heights[i]);
        }
        return max;
    }


    public static int largestRectangleArea2(int[] heights) {
        int max = 0;
        int[] h = new int[heights.length + 1];
        int len = h.length;
        if (heights.length - 1 >= 0) System.arraycopy(heights, 0, h, 0, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int cur = stack.poll();//被弹出点

                //i是出栈元素后第一个比它小的元素
                //left是出栈元素前一个比他小的元素
                if (stack.isEmpty())//被弹出元素是栈中最后一个元素
                    max = Math.max(max, (i * h[cur]));
                else {
                    int left = stack.peek();
                    max = Math.max(max, (i - left - 1) * h[cur]);
                }
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea2(new int[]{9});
    }
}
