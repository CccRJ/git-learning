package list;

/**
 * @program: Java_Learning
 * @description: 141 唤醒链表 双指针
 * @author: ChaiRJ
 * @create: 2020-03-11 11:06
 **/
public class HasCycle141 {
    public boolean hasCycle(ListNode head){
        if (head == null)return false;
        ListNode slow = head,fast = head.next;
        while (slow != fast){
            //一快一慢指针，快指针在慢指针后面，如果有环一定能追上
            if (fast == null || fast.next == null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
