package class012_partitionLinkedList;

//   https://leetcode.com/problems/partition-list/
public class PartitionLinkedList {
    public class ListNode{
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

        public ListNode partition(ListNode head, int x){
            if(head == null){
                return head;
            }

            ListNode leftHead = null, leftTail = null;
            ListNode rightHead = null, rightTail = null;
            ListNode next = null;

            while(head!= null){
                //断开head 和 其下一个节点的链接，断开即让head.next = null;
                //断开之前，要先保存下一个node的地址到next
                next = head.next;
                //这一步还能达到的目的是让leftTail = head之后，leftTail.next = null;
                // rightTail、rightHead, leftHead 同理
                head.next = null;

                if(head.val < x){
                   if(leftHead == null){
                       leftHead = head;
                   }else{
                       //当leftHead = head之后，leftTail.next = head，这一步是的rightHead.next
                       //变成了新的head，同时新的head.next = null;是链表不会陷入循环。
                       //right同理
                       leftTail.next = head;
                   }
                   leftTail = head;
                }else{
                    if(rightHead == null){
                        rightHead = head;
                    }else{
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = next;
            }
            if(leftHead == null){
                return rightHead;
            }
            leftTail.next = rightHead;
            return leftHead;
        }
    }
}
