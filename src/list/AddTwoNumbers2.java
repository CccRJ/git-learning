package list;

import java.util.Stack;

/**
 * @program: Java_Learning
 * @description: 两数相加，返回结果链表，从头开始
 * @author: ChaiRJ
 * @create: 2020-04-14 18:32
 **/
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        //取出数字存如栈
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        ListNode head = null;
        //出栈
        while (!s1.isEmpty() || !s2.isEmpty() || c != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int cur = a + b + c;
            c = cur / 10;
            cur = cur % 10;
            ListNode node = new ListNode(cur);
            node.next = head;
            head = node;
        }
        return head;
    }
}
