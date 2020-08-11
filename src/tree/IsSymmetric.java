package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Java_Learning
 * @description: 101 对称二叉树--给定二叉树判断是否镜像对称
 * @author: ChaiRJ
 * @create: 2020-02-15 15:57
 **/
public class IsSymmetric {
    private List<Integer> pro = new ArrayList<>();
    private List<Integer> post = new ArrayList<>();
    public boolean isSymmetric(TreeNode root){
        dlr(root);
        lrd(root);
        System.out.println(pro);
        System.out.println(post);
        //判断前序后序是否对称
        int len = pro.size();
        for (int i = 0; i < len; i++) {
            if(pro.get(i) != post.get(len - 1 - i))return false;
        }
        return true;
    }
    //把前序遍历存到数组里
    private void dlr(TreeNode node){
        if(node != null){
            pro.add(node.val);
            dlr(node.left);
            dlr(node.right);
        }
        else pro.add(null);
    }
    //把后序遍历存到数组里
    private void lrd(TreeNode node){
        if(node != null){
            lrd(node.left);
            lrd(node.right);
            post.add(node.val);
        }
        else post.add(null);
    }
    /**
    * @Description: 递归满足 1-两个根节点具有相同值 2-每个树的左子树与另一个的右子树镜像
    * @Param: [t1, t2]
    * @return: boolean
    * @Author: ChaiRJ
    * @Date: 2020/2/15
    */
    private boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null)return true;
        if(t1 == null || t2 == null)return false;

        return (t1.val == t2.val)
                && isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
    }
    /**
    * @Description: 迭代 上一状态的值等于下一个状态开始
    * @Param: [node]
    * @return: boolean
    * @Author: ChaiRJ
    * @Date: 2020/2/15
    */
    public boolean isSymmetric2(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        q.add(node);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll(),t2 = q.poll();
            if(t1 == null && t2 == null)continue;
            if(t1 == null || t2 == null)return false;
            if(t1.val != t2.val)return false;
            //左右子树交叉加入队列
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    public static void main(String[] args) {
        IsSymmetric is = new IsSymmetric();
        //通过new tree().convert(int[] nums) 构造一个list 然后带入new tree()构造树，再获得根节点
        System.out.println(is.isSymmetric(new Tree(new Tree().convert(new Integer[]{1,2,2,0,3,0,3})).getRoot()));
    }
}
