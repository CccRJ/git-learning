package match.week197;

import javax.swing.text.html.ListView;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 5211. 概率最大的路径
 * @author: ChaiRJ
 * @create: 2020-07-12 11:02
 **/
public class MaxProbability5211 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int len = edges.length;
        double max = 0;
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            //判空
            map.computeIfAbsent(a, k -> new HashMap<>());
            map.get(a).put(b, succProb[i]);
            map.computeIfAbsent(b, k -> new HashMap<>());
            map.get(b).put(a, succProb[i]);
        }

        Deque<Integer> node = new LinkedList<>();
        Deque<Double> pro = new LinkedList<>();
        boolean[] visited = new boolean[n];
        double[] maxPro = new double[n];

        node.offer(start);
        pro.offer(1.0);
        while (node.size() != 0) {
            int x = node.remove();
            double xpro = pro.remove();
            HashMap<Integer, Double> submap = map.get(x);

            if ((maxPro[x]<xpro || !visited[x]) && submap != null) {
                maxPro[x] = xpro;
                visited[x] = true;
                for (Map.Entry<Integer, Double> entry : submap.entrySet()) {
                    if (entry.getKey() == end) max = Math.max(max, xpro * entry.getValue());
                    else {
                        node.offer(entry.getKey());
                        pro.offer(xpro * entry.getValue());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProbability5211().maxProbability(4, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 2},{2,4}}, new double[]{0.5, 0.5, 0.4, 0.9, 0.1}, 0, 4));
    }
}
