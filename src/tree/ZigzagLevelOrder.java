package tree;

import java.util.*;

/**
 * @program: Java_Learning
 * @description: 103 二叉树锯齿形层级遍历
 * @author: ChaiRJ
 * @create: 2020-02-19 21:31
 **/
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        //栈先进后出 实现锯齿
        Stack<TreeNode> s = new Stack<>(),sNext = new Stack<>();

        s.add(root);

        int level = 0;
        while(!s.isEmpty()){
            res.add(new ArrayList<Integer>());

            int len = s.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = s.pop();

                res.get(level).add(node.val);

                //加入下一行的栈，奇数行左边先进 右边先出
                if(level % 2 == 0){
                    if(node.left != null)sNext.add(node.left);
                    if(node.right != null)sNext.add(node.right);
                }
                if(level % 2 == 1){
                    if(node.right != null)sNext.add(node.right);
                    if(node.left != null)sNext.add(node.left);
                }
            }
            s = sNext;
            sNext = new Stack<>();
            level++;
        }
        return res;
    }
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            res.add(new ArrayList<Integer>());

            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();

                res.get(level).add(node.val);

                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            //奇数行转换顺序
            if(level % 2 == 1) {
                List<Integer> temp = new ArrayList<>();
                int size = res.get(level).size();
                for (int i = size - 1; i >= 0; i--) {
                    temp.add(res.get(level).get(i));
                }
                res.remove(level);
                res.add(temp);
            }

            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(new Tree(new Tree().convert(new Integer[]{1,2,3,4,0,0,5})).getRoot()));
    }
}
