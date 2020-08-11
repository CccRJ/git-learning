package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Java_Learning
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @author: ChaiRJ
 * @create: 2020-06-30 13:50
 **/
class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();//入队列
        stack2 = new LinkedList<>();//出队
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.size() == 0 ? -1 : stack2.pop();
    }

}

public class CQueueOffer09 {
    public static void main(String[] args) {
        CQueue cq = new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.deleteHead();
        cq.appendTail(3);
        cq.deleteHead();
        cq.deleteHead();
        System.out.println(cq);
    }
}
