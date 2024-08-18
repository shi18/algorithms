package class013_queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) {
        System.out.println("test");
    }
    public static class QueueJava{
        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty(){
            return queue.isEmpty();
        }
        //add ele to queue
        public void offer(int num){
            queue.offer(num);
        }
        //take ele from queue
        public int poll(){
            return queue.poll();
        }
        //view first ele of queue
        public int peek(){
            return queue.peek();
        }
        //get size of queue
        public int size(){
            return queue.size();
        }

    }

    public static class QueueArray{
        int[] queue;
        int l, r;

        //check is empty or not
        public boolean isEmpty(){
            return l == r;
        }
        //add element
        public void offer(int num){
            queue[r++] = num;
        }
        //get ele
        public int pool(){
            return queue[l--];
        }
        //view ele
        public int head(){
            return queue[l];
        }
        //view tail
        public int tail(){
            return queue[r-1];
        }
        //get size
        public int size(){
            return r-l;
        }
    }

}
