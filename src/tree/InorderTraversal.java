package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    /*
    * 94 树 中序遍历
    * */

    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        ldr(root);

        return res;
    }
    private void ldr(TreeNode root){
        if(root != null) {
            ldr(root.left);
            res.add(root.val);
            ldr(root.right);
        }
    }

    private TreeNode creatTree(int[] tree){
        TreeNode node = new TreeNode(tree[0]);
        TreeNode root = node;

        int i = 1;
        while(i < tree.length){

        }
        return root;
    }
    public static void main(String[] args) {
        InorderTraversal i = new InorderTraversal();


        //System.out.println(i.inorderTraversal());
    }
}
