package class015_minEleInStack;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class GetMinInStack {
    class MinStack {
        Stack<Integer> in;
        Stack<Integer> min;
        public MinStack() {
            in = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            in.push(val);
            if(min.isEmpty() || min.peek() >= val){
                min.push(val);
            }else{
                min.push(min.peek());
            }
        }

        public void pop() {
            in.pop();
            min.pop();
        }

        public int top() {
            return in.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
