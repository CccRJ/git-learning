package 剑指Offer;

import list.ListNode;

/**
 * @program: Leetcode
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * @author: ChaiRJ
 * @create: 2020-07-16 12:04
 **/
public class GetKthFromEnd22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head,latter = head;
        for(int i = 0;i < k;i++)former = former.next;
        while (former != null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
