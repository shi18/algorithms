package class027_FreqQuesOfHeap;

import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeLinkedList {
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

            for(ListNode h : lists){
                if(h != null){
                    heap.add(h);
                }
            }
            if(heap.isEmpty()){
                return null;
            }
            ListNode h = heap.poll();
            ListNode pre = h;
            if(pre.next!= null){
                heap.add(pre.next);
            }
            while(!heap.isEmpty()){
                ListNode cur = heap.poll();
                pre.next = cur;
                pre = cur;
                if(cur.next != null){
                    heap.add(cur.next);
                }
            }
            return h;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
