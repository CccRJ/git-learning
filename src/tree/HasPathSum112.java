package tree;

/**
 * @program: Java_Learning
 * @description: 112. 路径总和
 * @author: ChaiRJ
 * @create: 2020-07-07 15:39
 **/
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        System.out.println(new HasPathSum112().hasPathSum(Tree.creatTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 0));
    }
}
