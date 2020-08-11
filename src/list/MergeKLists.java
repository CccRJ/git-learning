package list;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(mergeKLists(new ListNode[]{l1,l2,l2}));
    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)return null;
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0],lists[i]);
        }
        return lists[0];
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null){
            if(l1 == null){//l1空 直接拼接l2
                head.next = l2;
                break;
            }
            if(l2 == null){
                head.next = l1;
                break;
            }

            //l1 l2 都非空
            ListNode l;
            if(l1.val < l2.val){
                l = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                l = new ListNode(l2.val);
                l2 = l2.next;
            }
            l.next = null;
            head.next = l;
            head = head.next;

        }
        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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

    public ListNode merge(ListNode[] lists,int l,int r){
        if (l==r)return lists[l];
        if (l>r)return null;
        int mid = l + (r - l)/2;
        return mergeTwoLists2(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    /**
     * 归并算法 时间复杂度 O(kn*logk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        return merge(lists,0,lists.length);
    }
}
