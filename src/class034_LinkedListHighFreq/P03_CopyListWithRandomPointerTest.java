package class034_LinkedListHighFreq;public class P03_CopyListWithRandomPointerTest {    public static void main(String[] args) {        P03_Node n1 = new P03_Node(2);        P03_Node n2 = new P03_Node(3);        P03_Node n3 = new P03_Node(4);        P03_Node n4 = new P03_Node(1);        n1.next = n2;        n2.next = n3;        n3.next = n4;        n4.next = null;        n1.random = n3;        n2.random = n4;        n3.random= null;        n4.random = n1;        P03_Node cur = n1;        System.out.println("n1 address : " + n1);        while(n1 != null){            System.out.println("val : " + n1.val + " next : "                    + (n1.next != null ? n1.next.val : 0) + " random : "                    + (n1.random != null ? n1.random.val : 0));            n1 = n1.next;        }        P03_CopyListWithRandomPointer tmp = new P03_CopyListWithRandomPointer();        P03_Node ans = tmp.copyRandomList(cur);        System.out.println("ans address : " + ans);        while(ans != null){            System.out.println("val : " + ans.val + " next : "                    + (ans.next != null ? ans.next.val : 0) + " random : "                    + (ans.random != null ? ans.random.val : 0));            ans = ans.next;        }    }}