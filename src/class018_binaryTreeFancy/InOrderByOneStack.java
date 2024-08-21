package class018_binaryTreeFancy;

import java.util.Stack;
//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InOrderByOneStack {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    //inorder
    public static void inOrder(TreeNode head){
        if(head != null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.val + "");
                    head = head.right;
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

        inOrder(head);
        System.out.println("中序遍历非递归版");

    }



}
