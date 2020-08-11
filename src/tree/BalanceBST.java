package tree;

import java.util.ArrayList;

/**
 * @program: Java_Learning
 * @description: 5179 平衡搜索树变平衡 180周测
 * @author: ChaiRJ
 * @create: 2020-03-15 20:10
 **/
public class BalanceBST {
    ArrayList<TreeNode> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        ldr(root);

        return buildTree(0, list.size() - 1);
    }

    private TreeNode buildTree(int l, int r) {
        if (l > r) return null;
        int curRootIndex = (l + r) / 2;
        TreeNode curRoot = list.get(curRootIndex);
        curRoot.left = buildTree(l, curRootIndex - 1);
        curRoot.right = buildTree(curRootIndex + 1, r);
        return curRoot;
    }

    private void ldr(TreeNode node) {
        if (node == null) return;
        ldr(node.left);
        list.add(node);
        ldr(node.right);
    }
}
