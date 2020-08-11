package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description: 指 Offer 30. 包含min函数的栈
 * @author: ChaiRJ
 * @create: 2020-07-16 15:09
 **/
public class MinStack {
    private Deque<Integer> min;
    private Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() > x){
            min.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
