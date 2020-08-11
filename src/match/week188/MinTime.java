package match.week188;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 5406. 收集树上所有苹果的最少时间
 * @author: ChaiRJ
 * @create: 2020-05-10 10:56
 **/
public class MinTime {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int ans=0;
        boolean[] visited=new boolean[n];
        visited[0]=true;
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[1],edge[0]);
        }
        for (int i = 0; i < hasApple.size(); i++) {
            if (!hasApple.get(i))continue;
            else if (visited[i])continue;
            else{
                ans+=2;
                visited[i]=true;
                int p=map.get(i);
                while (!visited[p]){
                    ans+=2;
                    visited[p]=true;
                    p=map.get(p);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Boolean> l=new ArrayList<>(){
            {
                add(true);
                add(false);
                add(false);
                add(false);
                add(true);
                add(false);
                add(false);
            }
        };
        int[][] t=new int[][]{{0,1},{1,2},{2,3},{2,4},{3,5},{0,6}};
        minTime(7,t,l);
    }
}
