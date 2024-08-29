package class027_FreqQuesOfHeap;

import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    class Solution {
        public int halveArray(int[] nums) {
            double sum = 0;
            int ans = 0;

            PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                heap.add((double) nums[i]);
            }
            sum /= 2;

            for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
                cur = heap.poll() / 2;
                heap.add(cur);
            }
            return ans;
        }

        public static int MAXN = 100001;
        public static long[] heap = new long[MAXN];
        public static int size;

        public static int halveArray2(int[] nums) {
            size = nums.length;
            long sum = 0;
            for (int i = size - 1; i >= 0; i--) {
                heap[i] = (long) nums[i] << 20;
                sum += heap[i];
                heapify(i);
            }
            sum /= 2;
            int ans = 0;

            for (long minus = 0; minus < sum; ans++) {
                heap[0] /= 2;
                minus += heap[0];
                heapify(0);
            }
            return ans;
        }

        public static void heapify(int i) {
            int l = 2 * i + 1;
            while (l < size) {
                int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
                best = heap[best] > heap[i] ? best : i;
                if (best == i) {
                    break;
                }
                swap(i, best);
                i = best;
                l = 2 * i + 1;
            }
        }

        public static void swap(int i, int j) {
            long tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }
}
