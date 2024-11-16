package class034_LinkedListHighFreq;

public class P02_ReverseNodesInkGroupTest {
    public static void main(String[] args) {
        P02_ListNode nodeOne = new P02_ListNode(3);
        P02_ListNode nodeTwo = new P02_ListNode(4);
        P02_ListNode nodeThree = new P02_ListNode(2);

        P02_ListNode nodeFour = new P02_ListNode(5);
        P02_ListNode nodeFive = new P02_ListNode(3);
        P02_ListNode nodeSix = new P02_ListNode(6);
        P02_ListNode nodeSeven = new P02_ListNode(7);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;

        P02_ReverseNodesInkGroup reverseTest = new P02_ReverseNodesInkGroup();
        System.out.println(nodeOne);
        P02_ListNode node = nodeOne;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("after reverse");
        P02_ListNode tmp = reverseTest.reverseKGroup(nodeOne, 3);
        System.out.println("tmp :" +  tmp);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
