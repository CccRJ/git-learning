package tree;

/**
 * @program: Java_Learning
 * @description: 236.二叉树最近公共祖先
 * @author: ChaiRJ
 * @create: 2020-05-11 11:59
 **/
public class LowestCommonAncestor {
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        //1 如果左右都包含，则一边一个， 2  如果一个节点是目标节点，另一个节点包含或也是目标节点
        //两个条件返回root
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
            ans = root;
        //返回自己是不是，或者包不包含 目标节点
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private TreeNode res;
    private boolean dfs2(TreeNode root,TreeNode p,TreeNode q){
        if (root==null)return false;
        boolean lson = dfs2(root.left,p,q);
        boolean rson=dfs2(root.right,p,q);
        if ((lson && rson) || ((lson || rson) && (root.val.equals(p.val) || root.val.equals(q.val))))
            res = root;
        return lson || rson || (root.val.equals(p.val) || root.val.equals(q.val));
    }
}
