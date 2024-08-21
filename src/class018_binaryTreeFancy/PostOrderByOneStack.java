package class018_binaryTreeFancy;

import java.util.Stack;

public class PostOrderByOneStack {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }


    //postOrder by one stack
    public static void postOrderOneStack(TreeNode h){
        if(h != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            //if not print h, h is head
            //if printed, h is printed node
            //then h means last printed node
            while(!stack.isEmpty()){
                TreeNode cur = stack.peek();
                if(cur.left != null & h != cur.left && h != cur.right){
                    stack.push(cur.left);
                }else if(cur.right != null && h != cur.right){
                    stack.push(cur.right);
                }else{
                    System.out.println(cur.val + " ");
                    h = stack.pop();
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        postOrderOneStack(head);
        System.out.println("后序遍历非递归版 - 1个栈实现");
    }

}
