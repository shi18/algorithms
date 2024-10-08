package class009_linkedList;

import java.util.List;
//https://leetcode.com/problems/reverse-linked-list/
public class LinkedListReverse {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    class Solution{
        public ListNode reverseList(ListNode head){
            ListNode pre = null;
            ListNode next = null;
            while(head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}



