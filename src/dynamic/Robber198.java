package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 打家劫舍问题 198
 * @author: ChaiRJ
 * @create: 2020-06-20 22:26
 **/
public class Robber198 {
    /**
     * 打家劫舍，不能偷相邻房间，最高金额
     * @param nums
     * @return
     */
    public int rob1(int[] nums){
        int length = nums.length;

        int[] dp = new int[length+2];
        //从第i步开始抢劫，能抢到的最多
        for (int i = length-1; i >= 0; i--) {
            //当前房和下下间，或者下一间
            dp[i] = Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        return dp[0];
    }

    /**
     * 打家劫舍II，环形问题，最后一家和第一家是邻居
     * @param nums
     * @return
     */
    public int rob2(int[] nums){
        int length = nums.length;
        if (length==0)return 0;
        if (length==1)return nums[0];
        int[] nums1 = new int[length-1];
        int[] nums2 = new int[length-1];
        System.arraycopy(nums,0,nums1,0,length-1);
        System.arraycopy(nums,1,nums2,0,length-1);
        return Math.max(rob1(nums1),rob1(nums2));
    }

    /**
     * 二叉树打家劫舍，相邻节点不抢
     * @param root
     * @return
     */
    Map<TreeNode,Integer> cache = new HashMap<>();
    public int rob3(TreeNode root){
        if (root == null) return 0;
        //备忘录消除字重叠
        if (cache.containsKey(root))
            return cache.get(root);
        //偷当前节点，则下一步选择的是左右节点个字的子节点
        int do_rob = root.val
                + (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right))
                + (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));
        //不抢当前节点，选择当前节点的子节点
        int not_rob = rob3(root.left) + rob3(root.right);
        //缓存当前节点
        int res = Math.max(do_rob,not_rob);
        cache.put(root,res);
        return res;
    }
}
