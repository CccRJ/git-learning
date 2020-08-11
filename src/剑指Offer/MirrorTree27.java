package 剑指Offer;

import tree.TreeNode;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 27. 二叉树的镜像
 * @author: ChaiRJ
 * @create: 2020-07-16 13:21
 **/
public class MirrorTree27 {
    public TreeNode mirrorTree(TreeNode root){
        if (root == null)return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null)mirrorTree(root.left);
        if (root.right != null)mirrorTree(root.right);
        return root;
    }
}
