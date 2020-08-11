package list;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd1(ListNode head,int n){
        /*
        * 遍历两遍
        * */
        int len = 1;
        ListNode h = head;

        if(head == null) return null;
        //计算链表长度
        while(h.next!=null){
            len++;
            h = h.next;
        }
        System.out.println(len);

        if(n == len)//删除头节点
            return head.next;

        //找到删除位置
        h = head;
        for (int i = 1; i < len - n; i++) {
            h = h.next;
        }
        //删除节点
        if(n == 1)
            h.next=null;
        else
            h.next=h.next.next;
        return head;
    }
    public static ListNode removeNthFromEnd2(ListNode head,int n){
        /*
        * 遍历一边删除 一个链表的倒数第n个数返回删除后的链表
        * 第一个指针先移动，然后同时移动两个指针
        * */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next=node;
        //创建链表
        for (int i = 3; i < 6; i++) {
            node.next=new ListNode(i);
            node = node.next;
        }
        node.next=null;
        //打印结果
        System.out.println(head);
        //head = removeNthFromEnd(head,5);
        removeNthFromEnd2(head,2);
        System.out.println(head);
    }
}

