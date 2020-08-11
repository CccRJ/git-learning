package list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int n){val = n;}//构造函数

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode creatList(int[] nums){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        //尾部
        temp.next = null;
        return head.next;
    }
    @Override
    public String toString() {
        String val = Integer.toString(this.val);
        if(next != null){
            val = val.concat("->");
            val = val.concat(next.toString());
        }
        return val;
    }

}
