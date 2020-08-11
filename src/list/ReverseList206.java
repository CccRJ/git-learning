package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 206反转一个单链表
 * @author: ChaiRJ
 * @create: 2020-03-09 09:13
 **/
public class ReverseList206 {
    public static ListNode reversList(ListNode head){
        if (head == null)return null;
        List<ListNode> list = new ArrayList<>();

        while (head != null){
            list.add(head);
            head = head.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0){
                list.get(i).next = null;
                break;
            }
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }
    public static ListNode reversList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;//暂存下一个节点
            curr.next = prev;//指向上一个节点
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.creatList(new int[]{1,2,3,4,5});
        System.out.println(head.toString());
        System.out.println(reversList(head).toString());
    }
}
