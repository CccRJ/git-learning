package tree;

import java.util.Arrays;

/**
 * @program: Java_Learning
 * @description: 108 将有序数组转换为 平衡二叉搜索树
 * @author: ChaiRJ
 * @create: 2020-02-21 17:47
 **/
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums){
        int len = nums.length;
        if(len == 0)return null;

        //找中间点索引
        int index = len / 2;
        TreeNode root = new TreeNode(nums[index]);

        if(index > 0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,index));
        if(index < len - 1)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,index + 1,len));

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{1,2,3,4,5,6});
        System.out.println(LevelOrder.levelOrder2(root));
    }
}
