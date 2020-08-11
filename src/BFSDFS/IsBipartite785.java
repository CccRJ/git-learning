package BFSDFS;

/**
 * @program: Java_Learning
 * @description: 785. 判断二分图
 * @author: ChaiRJ
 * @create: 2020-07-16 11:04
 **/
public class IsBipartite785 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int len = graph.length;
        valid = true;
        color = new int[len];
        for (int i = 0; i < len; i++) {
            if (color[i] == UNCOLORED)
                dfs(RED, i);
        }
        return valid;
    }

    private void dfs(int nodeColor, int node) {
        color[node] = nodeColor;
        int neighborColor = nodeColor == RED ? GREEN : RED;
        for (int neighborNode : graph[node]) {
            if (color[neighborNode] == UNCOLORED) {
                dfs(neighborColor, neighborNode);
                if (!valid) return;
            } else if (color[neighborNode] != neighborColor) {
                valid = false;
                return;
            }
        }
    }
}
