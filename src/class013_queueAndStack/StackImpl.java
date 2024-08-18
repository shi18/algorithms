package class013_queueAndStack;

import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        System.out.println("test");
    }
    public class StackJava{
        public Stack<Integer> stack = new Stack<>();
         public boolean isEmpty(){
             return stack.isEmpty();
         }
         public void push(int num){
             stack.push(num);
         }
         public int pop(){
             return stack.pop();
         }
         public int peek(){
             return stack.peek();
         }
         public int size(){
             return stack.size();
         }
    }

    public class StackArray{
        int[] stack;
        int size;
        public StackArray(int n){
            stack = new int[n];
            size = 0;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void push(int num){
            stack[size++] = num;
        }
        public int pop(){
            return stack[--size];
        }
        public int peek(){
            return stack[size -1];
        }
        public int size(){
            return size;
        }
    }
}
