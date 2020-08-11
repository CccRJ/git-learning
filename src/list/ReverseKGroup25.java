package list;

/**
 * @program: Java_Learning
 * @description: 25 将链表反转，每k个做为一组进行反转，不足k个不变
 * @author: ChaiRJ
 * @create: 2020-06-29 09:31
 **/
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode tmp = head;
        //向后取k个节点
        for (int i = 1; i < k && tmp != null; i++) {
            tmp = tmp.next;
        }
        //判断是否够k个
        if (tmp == null)return head;

        ListNode nextHead = tmp.next;
        tmp.next = null;
        //当前k个逆序
        ListNode newHead = reverseList(head);
        //之后的节点分组逆序，递归
        ListNode newTmp = reverseKGroup(nextHead, k);
        //连接
        head.next = newTmp;

        return newHead;
    }
    //逆序单链表
    private static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null,curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //逆序单链表--递归
    private static ListNode reverseList2(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        //递归后面的部分逆序
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
