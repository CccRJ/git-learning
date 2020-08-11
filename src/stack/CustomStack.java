package stack;


import java.util.LinkedList;

/**
 * @program: Java_Learning
 * @description: 5357 支持增量操作的栈 180周赛
 * @author: ChaiRJ
 * @create: 2020-03-15 18:47
 **/
public class CustomStack {
    public int maxSize;
    public LinkedList<Integer> s = new LinkedList<>();

    public CustomStack(int maxSize){
        this.maxSize = maxSize;
    }
    public void push(int x){
        if (s.size() < maxSize){
            s.push(x);
        }
    }
    public int pop(){
        if (s.size()==0)return -1;
        else return s.pop();
    }
    public void increment(int k,int val){
        if (s.size()==0)return;
        if (k>s.size()){
            for (int i = 0; i < s.size(); i++) {
                s.set(i,s.get(i)+val);
            }
        }
        else{
            for (int i = 1; i <= k; i++) {
                s.set(s.size()-i,s.get(s.size()-i)+val);
            }
        }
    }

    public static void main(String[] args) {

    }
}
