package tree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    /*
    * 98 验证二叉搜索树
    * */
    public boolean isValidBST(TreeNode root){
        return recursive(root,null,null);
    }
    //迭代
    private boolean recursive(TreeNode node,Integer lower,Integer upper){
        if(node == null)return true;

        int val = node.val;
        //判断值是否符合
        if(lower != null && val <= lower)return false;
        if(upper != null && val >= upper)return false;

        //递归带入子树，改变上下限
        if(!recursive(node.left,lower,val))return false;
        if(!recursive(node.right,val,upper))return false;

        return true;
    }
    //中序遍历 每个遍历的数都大于前一个 则是排序二叉树
    private double pro = - Double.MAX_VALUE;
    private boolean ldr(TreeNode node){
        if(node != null){
            if(!ldr(node.left))return false;

            if(node.val > pro)
                pro = node.val;
            else return false;

            if (!ldr(node.right))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = new Tree().convert(new Integer[]{5,1,4,0,0,3,6});
        System.out.println(list);

        Tree tree = new Tree(list);
        IsValidBST i = new IsValidBST();
        System.out.println(i.ldr(tree.getRoot()));
    }
}
