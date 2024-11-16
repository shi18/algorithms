package class034_LinkedListHighFreq;
//https://leetcode.com/problems/reverse-nodes-in-k-group/

public class P02_ReverseNodesInkGroup {
    public static P02_ListNode reverseKGroup(P02_ListNode head, int k){
        P02_ListNode start = head;
        P02_ListNode end = teamEnd(head, k);
        if(end == null){
            return head;
        }
        head = end;
        System.out.println("start : " + start);
        System.out.println("end :" + end);
        reverse(start, end);
        System.out.println("start : " + start);
        System.out.println("end :" + end);

        P02_ListNode lastTeamEnd = start;
        while(lastTeamEnd.next != null){
            start = lastTeamEnd.next;
            end = teamEnd(start, k);
            if(end == null){
                return head;
            }
            reverse(start, end);
            lastTeamEnd.next = end;
            lastTeamEnd = start;
        }
        return head;
    }
    public static P02_ListNode teamEnd(P02_ListNode s, int k){
        while(--k != 0 && s != null){
            s = s.next;
        }
        return s;
    }
    public static void reverse(P02_ListNode s, P02_ListNode e){
        e = e.next;
        P02_ListNode pre = null, cur = s, next = null;
        while(cur != e){
            next = cur.next;
            cur.next =pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }
}