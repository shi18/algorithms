package class013_queueAndStack;
//https://leetcode.com/problems/design-circular-queue/
public class LoopQueue {
    class MyCircularQueue {
        int[] queue;
        int l,r,size,limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }else{
                queue[r] = value;
                r = r == limit - 1 ? 0 : (r + 1);
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }else{
                l = l == limit -1 ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }else{
                return queue[l];
            }
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }else{
                int last = r == 0 ? (limit - 1) : (r - 1);
                return queue[last];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return limit == size;
        }
    }
}
