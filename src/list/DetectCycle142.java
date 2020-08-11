package list;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Java_Learning
 * @description: 142 环形链表II
 * @author: ChaiRJ
 * @create: 2020-06-26 23:06
 **/
public class DetectCycle142 {
    /**
     * hashset 记录所有出现过的节点，重复出现则为环起点，否则为null
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null){
            if (visited.contains(node)){
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * Floyd算法，先判断是否有环，再找头节点
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)return null;
        ListNode slow = head.next,fast = head.next.next;
        while (fast!=slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //找到快慢指针相遇点
        while (head!=slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
