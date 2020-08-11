package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: Java_Learning
 * @description: 225 用队列实现栈
 * @author: ChaiRJ
 * @create: 2020-03-09 17:43
 **/
public class MyStack {
    private Deque<Integer> q = new LinkedList<>();
    public MyStack() {
    }
    public void push(int x){
        q.add(x);
    }
    public int pop(){
        return q.pollLast();
    }
    public int top(){
        return q.peekLast();
    }
    public boolean empty(){
        return q.isEmpty();
    }
}
