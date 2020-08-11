package match.doubleweek25;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 5384 拥有最多糖果的孩子
 * @author: ChaiRJ
 * @create: 2020-05-02 22:33
 **/
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = -1;
        for (int candy : candies) {
            if (candy > max) max = candy;
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) res.add(true);
            else
                res.add(false);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new KidsWithCandies().kidsWithCandies(new int[]{12,1,12},10));
    }
}
