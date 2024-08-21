package class017_binaryTreeBasic;

public class BinaryTreeRecursion {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        //递归基本形式
        public static void f(TreeNode head){
            if(head == null){
                return ;
            }
            //1
            f(head.left);
            //2
            f(head.right);
            //3
        }

        public static void preOrder(TreeNode head){
            System.out.println("current node is: " + (head == null ? -1 : head.val));
            if(head == null){
                return ;
            }

            System.out.println("res " + head.val + " ");
            preOrder(head.left);
            preOrder(head.right);
        }

        public static void inOrder(TreeNode head){
            System.out.println("current node is: " + (head == null ? -1 : head.val));
            if(head == null){
                return;
            }
            inOrder(head.left);
            System.out.println("res " + head.val + " ");
            inOrder(head.right);
        }

        public static void postOrder(TreeNode head){
            System.out.println("current node is: " + (head == null ? -1 : head.val));
            if(head == null){
                return ;
            }
            postOrder(head.left);
            postOrder(head.right);
            System.out.println("res " + head.val + " ");
        }

        public static void main(String[] args) {
            TreeNode head = new TreeNode(1);
            head.left = new TreeNode(2);
            head.right = new TreeNode(3);
            head.left.left = new TreeNode(4);
            head.left.right = new TreeNode(5);
            head.right.left = new TreeNode(6);
            head.right.right = new TreeNode(7);

            preOrder(head);
            System.out.println("preOrder");
            System.out.println("");

            inOrder(head);
            System.out.println("inOrder");
            System.out.println("");

            postOrder(head);
            System.out.println("postOrder");
            System.out.println("");
        }
    }
}
