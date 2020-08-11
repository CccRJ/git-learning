package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Java_Learning
 * @description: 138 复制带随机指针的链表，深拷贝
 * @author: ChaiRJ
 * @create: 2020-03-05 16:58
 **/
class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public static Node copyRandomList(Node head){
        Map<Integer,Node> map = new HashMap<>();
        Node temp = head;
        if (head == null)return null;
        int len = 0;

        while (temp!= null){//把所有点加入map
            Node node = new Node(temp.val);
            //把当前节点的val变成序号
            temp.val = len;
            map.put(len++,node);
            temp = temp.next;
        }
        for (int i = 0; i < len; i++) {
            //添加random指针
            if(head.random != null){
                //当前节点的val就是random指向的序号
                map.get(i).random = map.get(head.random.val);
                head = head.next;
            }
            else head = head.next;
            //添加next指针
            if (i == len - 1){
                map.get(i).next = null;
            }
            else{
                map.get(i).next = map.get(i + 1);
            }
        }
        return map.get(0);
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(8);
        Node n3 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n1.random = n3;
        n2.random = null;
        n3.random = n1;
        copyRandomList(n1);
    }
}
