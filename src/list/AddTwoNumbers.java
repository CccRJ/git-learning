package list;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(6);
        l1.next = new ListNode(3);
        l2.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res.val+","+res.next.val);
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        /*
        * 2 两数相加
        * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
        * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        * */
        ListNode head = new ListNode(0);
        //用curr接收head，在返回值的时候head还是头指针，位置没有改变
        ListNode n1 = l1, n2 = l2, curr = head;
        int carry = 0;
        while (n1 != null || n2 != null) {
            //判断是否为空 为空传0
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
