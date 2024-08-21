package class018_binaryTreeFancy;

import java.util.Stack;
//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreOrderByOneStack {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    //preOrder
    public static void preOrder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.val + "");
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
        System.out.println();
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
        System.out.println("先序遍历非递归版");
    }

}
