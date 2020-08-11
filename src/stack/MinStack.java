package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: Java_Learning
 * @description: 155 能够常数时间内找到最小元素的栈
 * @author: ChaiRJ
 * @create: 2020-03-19 21:03
 **/
public class MinStack {
    private Stack<Integer> stack;
    private ArrayList<Integer> minList;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        minList = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minList.add(min);
    }

    public void pop() {
        stack.pop();
        minList.remove(minList.size() - 1);
        //min等于前一个min，空列表 初始化min
        min = minList.size() > 0 ? minList.get(minList.size() - 1) : Integer.MAX_VALUE;
    }

    public int top() {
        return stack.peek();
    }

    //返回当前最小值
    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
