package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 118 杨辉三角
 * @author: ChaiRJ
 * @create: 2020-02-21 21:42
 **/
public class YangHuiTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)return res;

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        if(numRows == 1)return res;

        temp = new ArrayList<Integer>(){{
            add(1);
            add(1);
        }};
        res.add(temp);

        for (int level = 2; level < numRows; level++) {
            res.add(new ArrayList<>());
            for (int n = 0; n < level + 1; n++) {
                if(n == 0 || n == level){
                    res.get(level).add(1);
                }
                else
                    res.get(level).add(res.get(level - 1).get(n - 1) + res.get(level - 1).get(n));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
