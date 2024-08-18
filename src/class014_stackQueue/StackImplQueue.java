package class014_stackQueue;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class StackImplQueue {
    class MyQueue{
        Stack<Integer> in;
        Stack<Integer> out;
        MyQueue(){
            this.in = new Stack<>();
            this.out = new Stack<>();
        }
        private void inToOut(){
            if(out.empty()){
                while(!in.empty()){
                    out.push(in.pop());
                }
            }
        }
        public void push(int x){
            in.push(x);
            inToOut();
        }
        public int pop(){
            inToOut();
            return out.pop();
        }
        public int peek(){
            inToOut();
            return out.peek();
        }
        public boolean empty(){
            return in.isEmpty() && out.isEmpty();
        }
    }
}
