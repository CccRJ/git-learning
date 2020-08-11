package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Java_Learning
 * @description: 102 二叉树层级遍历 逐层访问节点
 * @author: ChaiRJ
 * @create: 2020-02-19 20:21
 **/
public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        //空
        if(root == null)return res;
        //队列 和 下一排
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qNext = new LinkedList<>();

        TreeNode node;
        List<Integer> temp = new ArrayList<>();//暂存

        q.add(root);
        qNext.add(root);

        while (!qNext.isEmpty()){
            //清空qNext
            qNext.clear();

            while(!q.isEmpty()){//取值，子节点存入下一层
                node = q.poll();
                temp.add(node.val);
                if(node.left != null)qNext.add(node.left);
                if(node.right != null)qNext.add(node.right);
            }
            res.add(new ArrayList<>(temp));
            temp.clear();

            q = new LinkedList<>(qNext);
        }
        return res;
    }
    public static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            //存当前行
            res.add(new ArrayList<Integer>());

            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();

                res.get(level).add(node.val);

                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(new Tree(new Tree().convert(new Integer[]{1,2})).getRoot()));
    }
}
