package tree;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 105 前序中序遍历构造二叉树
 * @author: ChaiRJ
 * @create: 2020-02-20 20:57
 **/
public class BuildTreeProIn {
    /**
    * @Description: 递归，找到根节点，拆分数组继续调用函数
    * @Param: [preorder, inorder]
    * @return: tree.TreeNode
    * @Author: ChaiRJ
    * @Date: 2020/2/21
    */
    public static TreeNode buildTree(int[] preorder,int[] inorder){
        int len = preorder.length;
        if(len == 0)return null;

        TreeNode root = new TreeNode(preorder[0]);

        //找到根节点的索引值
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]){
                index = i;
                break;
            }
        }

        if(index > 0)//有左子树
            root.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),Arrays.copyOfRange(inorder,0,index));
        if(index < len - 1)//有右子树
            root.right = buildTree(Arrays.copyOfRange(preorder,index + 1,len),Arrays.copyOfRange(inorder,index + 1,len));

        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{1,2,3,4},3));
        TreeNode root = buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(LevelOrder.levelOrder2(root));
    }
}
