package BFSDFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: Java_Learning
 * @description: 994 腐烂橘子，所有橘子腐烂需要的最小时间
 * @author: ChaiRJ
 * @create: 2020-03-09 18:02
 **/
public class OrangesRotting {
    private int[][] direct = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid){
        if (grid.length == 0) return 0;
        int r = grid.length,c = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();

        //初始化队列
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2){
                    int code = i * c + j;//当前行*总列数+当前列，等于当前节点的索引，通过除法取余计算
                    q.add(code);
                    map.put(code,0);//第二个值表示当前是第几轮计算
                }
            }
        }
        //循环
        int ans = 0;
        while (!q.isEmpty()){
            int code = q.poll();
            int i = code / c,j = code % c;
            for (int k = 0; k < 4; k++) {
                int newR = i + direct[k][0];
                int newC = j + direct[k][1];
                if (newR >= 0 && newR < r && newC >= 0 && newC < c && grid[newR][newC] == 1){
                    grid[newR][newC] = 2;
                    int newCode = newR * c + newC;
                    q.add(newCode);
                    map.put(newCode,map.get(code) + 1);
                    ans = map.get(newCode);
                }
            }
        }
        for (int[] row : grid) {
            for (int x : row) {
                if (x == 1)return -1;//队列结束还有好橘子
            }
        }
        return ans;

    }
}
