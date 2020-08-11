package math;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 1103 分糖果 把糖果发完，每次多发一个，求最后发放情况
 * @author: ChaiRJ
 * @create: 2020-03-06 14:53
 **/
public class DistributeCandies {
    public static int[] distributeCandies(int candies,int num_people){
        int[] res = new int[num_people];
        for (int i = 0;; i++) {
            if(candies < i + 1){//糖果数不足
                res[i % num_people] += candies;
                break;
            }
            else {//糖果充足
                res[i % num_people] += i + 1;
                candies -= i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(60,4)));
    }

}
