package class034_LinkedListHighFreq;
public class P01_IntersectionOfTwoLinkedLIst {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode h1, ListNode h2){
        if(h1 == null || h2 == null){
            return null;
        }
        ListNode a = h1, b = h2;
        int diff = 0;
        while(a.next != null){
            a = a.next;
            diff++;
        }
        while(b.next != null){
            b= b.next;
            diff--;
        }
        if(a != b){
            return null;
        }
        if(diff >= 0){
            a = h1;
            b = h2;
        }else{
            a = h2;
            b = h1;
        }
        diff = Math.abs(diff);
        while(diff-- != 0){
            a = a.next;
        }
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
