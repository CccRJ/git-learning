package list;

import array.Rotate;

/**
 * @program: Java_Learning
 * @description: 61 旋转链表
 * @author: ChaiRJ
 * @create: 2020-06-22 11:19
 **/
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode newHead;
        ListNode left = head, right = head;

        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        //k是长度整数倍，返回原始list
        if (k%len==0)return head;

        //对k取余
        k %= len;
        //右指针先移动k步
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        //找到链表尾部节点
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        newHead = left.next;
        left.next = null;
        right.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        RotateRight61 rr = new RotateRight61();
        System.out.println(
                rr.rotateRight(ListNode.creatList(
                                new int[]{1,2}),2));
    }
}
