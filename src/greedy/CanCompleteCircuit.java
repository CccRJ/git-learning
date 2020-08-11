package greedy;

/**
 * @program: Java_Learning
 * @description: 134 加油站 贪心算法 加油绕路线一圈
 * @author: ChaiRJ
 * @create: 2020-03-05 16:13
 **/
public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas,int[] cost){
        int len = gas.length;
        int currTank = 0,totalTank = 0,start = 0;//当前油量，总油量，开始点
        for (int i = 0; i < len; i++) {
            currTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if (currTank < 0){//当前没油重新开始计算点
                currTank = 0;
                start = i + 1;
            }
        }
        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,2,4}));
    }
}
