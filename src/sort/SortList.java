package sort;

import list.ListNode;

/**
 * @program: Java_Learning
 * @description: 148 链表归并排序 时间复杂度O(nlogn)
 * @author: ChaiRJ
 * @create: 2020-03-18 22:15
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        //找到中间节点，平分
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //递归，返回排好序的子链表
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //头节点
        ListNode node = new ListNode(0);
        ListNode res = node;
        //两个有序链表合并
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }
            node = node.next;
        }
        //一个链表加完，另一个接在尾部
        node.next = left == null ? right : left;
        return res.next;
    }
}
