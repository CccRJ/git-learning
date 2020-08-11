package BFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 面试题13 机器人运动范围 上下左右移动，位置位数之和不能大于k
 * @author: ChaiRJ
 * @create: 2020-04-08 20:43
 **/
public class RobotMovingCount {
    private int res = 0;
    List<Integer> l=new ArrayList<>();
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        dfs(0, 0, grid,k);
        return res;
    }

    private void dfs(int x, int y, int[][] grid,int k) {
        int xLen = grid.length, yLen = grid[0].length;
        int sum=x/10+x%10+y/10+y%10;
        if (x < 0 || x >= xLen || y < 0 || y >= yLen || grid[x][y] == 1||sum>k) {
            return;
        }
        grid[x][y] = 1;
        res++;
        dfs(x + 1, y, grid,k);
        dfs(x - 1, y, grid,k);
        dfs(x, y + 1, grid,k);
        dfs(x, y - 1, grid,k);
    }

    public static void main(String[] args) {
        RobotMovingCount r=new RobotMovingCount();
        System.out.println(r.movingCount(3,1,0));
    }
}
