package list;

public class MergeTwoLists {
    /*
     * 连个有序链表合成一个有序链表
     * */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {//l1空 直接拼接l2
                head.next = l2;
                break;
            }
            if (l2 == null) {
                head.next = l1;
                break;
            }

            //l1 l2 都非空
            ListNode l;
            if (l1.val < l2.val) {
                l = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                l = new ListNode(l2.val);
                l2 = l2.next;
            }
            l.next = null;
            head.next = l;
            head = head.next;

        }
        return res.next;
    }

    /**
     * 合并两个字符串，递归实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

}
