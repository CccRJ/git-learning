package 剑指Offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 28. 对称的二叉树
 * @author: ChaiRJ
 * @create: 2020-07-16 13:27
 **/
public class IsSymmetric28 {
    public boolean isSymmetric(TreeNode root) {
        return judge(root.left,root.right);
    }
    private boolean judge(TreeNode left,TreeNode right){
        if (left == null && right == null)return true;
        if (left == null || right == null)return false;
        if (left.val == right.val){
            if(!judge(left.left, right.right))return false;
            if (!judge(left.right, right.left))return false;
            return true;
        }else return false;
    }

}
