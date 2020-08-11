package tree;

/**
 * @program: Java_Learning
 * @description: 543 二叉树直径 任意两点间最长距离
 * @author: ChaiRJ
 * @create: 2020-03-10 15:11
 **/
public class DiameterOfBinaryTree {
    private int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null)return 0;
        gainMax(root);
        return max - 1;
    }
    private int gainMax(TreeNode node){
        if (node == null) return 0;

        int lMax = Math.max(gainMax(node.left),0);
        int rMax = Math.max(gainMax(node.right),0);

        int newPath = 1 + lMax + rMax;

        max = Math.max(max,newPath);

        return 1 + Math.max(lMax,rMax);
    }
}
