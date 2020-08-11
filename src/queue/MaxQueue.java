package queue;

import java.util.*;

/**
 * @program: Java_Learning
 * @description: 自定义队列
 * @author: ChaiRJ
 * @create: 2020-03-07 18:23
 **/
public class MaxQueue {
    private int max = Integer.MIN_VALUE;
    private Queue<Integer> q = new LinkedList<>();
    private Deque<Integer> dq = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (dq.size() == 0)return -1;
        return dq.peekFirst();
    }

    public void push_back(int value) {
        while (!dq.isEmpty() && dq.peekLast() < value) {//所有小于该值的都弹出，最大值变为当前值
            dq.pollLast();
        }
        dq.add(value);
        q.add(value);
    }

    public int pop_front() {
        if (q.size() == 0) return -1;
        if (dq.getFirst().equals(q.peek())){
            dq.pollFirst();
        }
        return q.poll();
    }

    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();
        q.push_back(1);
        q.push_back(2);
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.max_value());
        System.out.println(q.max_value());
    }
}
