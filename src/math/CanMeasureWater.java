package math;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashSet;
import java.util.Stack;

/**
 * @program: Java_Learning
 * @description: 365.水壶问题
 * @author: ChaiRJ
 * @create: 2020-05-06 20:38
 **/
public class CanMeasureWater {
    public boolean canMeasureWater(int x,int y,int z){
        HashSet<entry> set=new HashSet<>();
        Stack<entry> s=new Stack<>();
        s.add(new entry(0,0));
        while (!s.isEmpty()){
            entry tmp=s.pop();
            int remainX=tmp.x,remainY=tmp.y;
            if (remainX==z||remainY==z||remainX+remainY==z)return true;

        }
        return false;
    }
    static class entry{
        public int x,y;
        public entry(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        HashSet<entry> s=new HashSet<>();
        entry e=new CanMeasureWater.entry(1,1);
        s.add(e);
        System.out.println(s.contains(new CanMeasureWater.entry(1,1)));
    }
}
