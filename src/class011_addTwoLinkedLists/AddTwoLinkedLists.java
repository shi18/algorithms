package class011_addTwoLinkedLists;
//  https://leetcode.com/problems/add-two-numbers/
public class AddTwoLinkedLists {
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
        public ListNode addTwoNumbers(ListNode h1, ListNode h2){
            ListNode ans = null, cur = null;
            int carry = 0;
            /*
            1. initialize sum and val
            2. if any both h1 and h2 == null, stop for loop, use || operation, if we use && operation, one of h1 and h2 is null, then for loop end;
            3. check h1 and h2, if null, then update to null, else update to .next;
            */
            for(int sum, val; h1 != null || h2 != null; h1 = h1 == null ? null : h1.next, h2 = h2 == null ? null : h2.next){
                /*
                deal with 3 conditions, all of them need to add carry at the end
                1. h1 != null and h2 != null, then sum = h1.val + h2.val + carry
                2. h1 == null and h2 != null, then sum = 0 + h2.val + carry
                3. h1 != null and h2 == null, then sum = h1. val + 0 + carry
                */
                sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
                val = sum % 10;
                carry = sum / 10;
                if(ans == null){
                    ans = new ListNode(val);
                    cur = ans;
                }else{
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
            if(carry == 1){
                cur.next = new ListNode(1);
            }

            return ans;
        }
    }

}
