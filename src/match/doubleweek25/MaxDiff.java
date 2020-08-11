package match.doubleweek25;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 5385 改变一个整数能得到最大差值
 * @author: ChaiRJ
 * @create: 2020-05-02 22:40
 **/
public class MaxDiff {
    public int maxDiff(int num) {
        int tmp=num;
        List<Integer> list=new ArrayList<>();

        while(num!=0){
            list.add(num%10);
            num/=10;
        }
        int max=0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i)==9)max=tmp;
            else{
                max=change(list,list.get(i),9);
                break;
            }
        }
        int min=0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i==list.size()-1 && list.get(i)!=1){
                min=change(list,list.get(i),1);
                break;
            }
            else if (i!=list.size()-1 && list.get(i)!=0 && list.get(i)!=list.get(list.size()-1)){
                min=change(list,list.get(i),0);
                break;
            }
            min = tmp;
        }
        System.out.println(max);
        System.out.println(min);
        return max-min;
    }
    //改变值并计算结果
    private int change(List<Integer> list,int x,int y){
        int res=0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i)==x)res=res*10+y;//把x变为y加入计算
            else
                res=res*10+list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDiff().maxDiff(1101057));
    }
}
