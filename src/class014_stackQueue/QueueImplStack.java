package class014_stackQueue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/
public class QueueImplStack {
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for( int i = 0; i < n; i++){
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return  queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
