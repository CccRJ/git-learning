package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public Tree(){}

    public Tree(List<Integer> list){
        //创建树，返回根节点
        this.root = creatTree(list);
    }

    /**
    * @Description: 根据数组创建二叉树
    * @Param: [list]
    * @return: tree.TreeNode
    * @Author: ChaiRJ
    * @Date: 2020/2/15
    */
    public static TreeNode creatTree(List<Integer> list){
        //创建队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        int count = 0;
        //给根节点赋值
        TreeNode root = new TreeNode(list.get(count++));
        queue.add(root);
        while(!queue.isEmpty() && count < list.size()){
            TreeNode lastNode = queue.poll();

            if(count < list.size()){
                Integer val = list.get(count++);
                if(val != null) {
                    TreeNode left = new TreeNode(val);
                    lastNode.left = left;
                    queue.add(left);
                }
                else
                    lastNode.left = null;
            }
            if(count < list.size()){
                Integer val = list.get(count++);
                if(val != null) {
                    TreeNode right = new TreeNode(val);
                    lastNode.right = right;
                    queue.add(right);
                }
                else
                    lastNode.right = null;
            }
        }
        return root;
    }
    //输入数组创建树
    public static TreeNode creatTree(Integer[] nums){
        return creatTree(convert(nums));
    }
    //前序遍历
    public void dlr(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            dlr(node.left);
            dlr(node.right);
        }
    }

    //把数组变成arraylist
    public static List<Integer> convert(Integer[] nums){
        return new ArrayList<>(Arrays.asList(nums));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(null);
        list.add(3);
        Tree tree = new Tree(list);
        tree.dlr(tree.root);
    }
}
