package class018_binaryTreeFancy;

import java.util.Stack;
//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrderByTwoStacks {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    //postOrder
    //preOrder      ： mid -> left -> right
    //preOrder prime: mid -> right -> left
    //put preOrder prime to a new stack
    //pop from new stack: left -> right -> mid;
    //using two stacks
    public static void postOrderTwoStacks(TreeNode head){
        if(head != null){
           Stack<TreeNode> stack = new Stack<>();
           Stack<TreeNode> collect = new Stack<>();
           stack.push(head);

           while(!stack.isEmpty()){
               head = stack.pop();
               collect.push(head);
               if(head.left != null){
                   stack.push(head.left);
               }
               if(head.right != null){
                   stack.push(head.right);
               }
           }
           while(!collect.isEmpty()){
               System.out.println(collect.pop() + " ");
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

        postOrderTwoStacks(head);
        System.out.println("后序遍历非递归版 - 2个栈实现");
    }

}
