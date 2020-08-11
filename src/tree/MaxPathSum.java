package tree;

/**
 * @program: Java_Learning
 * @description: 124 二叉树最大路径和 从任意节点出发到达任意节点
 * @author: ChaiRJ
 * @create: 2020-02-23 22:42
 **/
public class MaxPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        gainMax(root);
        return max;
    }
    private int gainMax(TreeNode node){
        if(node == null)return 0;

        //左右子树最大值
        int leftMax = Math.max(gainMax(node.left),0);
        int rightMax = Math.max(gainMax(node.right),0);

        //重新开始新路径的值
        int newPath = node.val + leftMax + rightMax;

        //更新最大值
        max = Math.max(newPath,max);

        //返回当前路径最大值
        return node.val + Math.max(leftMax,rightMax);
    }
}
