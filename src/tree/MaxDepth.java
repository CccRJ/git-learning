package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Java_Learning
 * @description: 104 二叉树最大深度
 * @author: ChaiRJ
 * @create: 2020-02-20 20:22
 **/
public class MaxDepth {
    public static int maxDepth(TreeNode root){//递归
        if(root == null)return 0;
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
        }
    }
    public static int maxDepth2(TreeNode root){//迭代层级遍历
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth2(new Tree(new Tree().convert(new Integer[]{1,2,3,4,5,6,7})).getRoot()));
    }
}
