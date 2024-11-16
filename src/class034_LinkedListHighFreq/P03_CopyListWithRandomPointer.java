package class034_LinkedListHighFreq;

public class P03_CopyListWithRandomPointer {
    public static P03_Node copyRandomList(P03_Node head){
        if (head == null){
            return null;
        }
        // 将当前节点复制，并插入到当前节点和下个节点中间
        P03_Node cur = head;
        P03_Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new P03_Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 对新节点设置random节点
        cur = head;
        P03_Node copy = null;
        while(cur != null){
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        P03_Node ans = head.next;
        cur = head;
        // 分离新老链表
        while(cur != null){
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        // 返回复制的链表的头节点
        return ans;
    }
}
