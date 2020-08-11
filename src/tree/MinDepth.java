package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Java_Learning
 * @description: 111.最小深度
 * @author: ChaiRJ
 * @create: 2020-06-20 21:42
 **/
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 1;
        int n = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            //遍历当前层级
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.remove();
                //左右节点为空，返回
                if (node.left == null && node.right == null) return depth;
                else {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
