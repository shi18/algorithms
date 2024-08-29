package class027_FreqQuesOfHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/description/
public class MeetRoomsII {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            return methodTwo(intervals);
        }

        public int methodOne(int[][] intervals) {
            int ans = 0;
            int n = intervals.length;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                while (!heap.isEmpty() && heap.peek() <= intervals[i][0]) {
                    heap.poll();
                }
                heap.add(intervals[i][1]);
                ans = Math.max(heap.size(), ans);
            }
            return ans;
        }

        public static int MAXN = 10001;
        public static int[] heap = new int[MAXN];
        public static int size;

        public int methodTwo(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals, 0, n, (a, b) -> a[0] - b[0]);
            int ans = 0;
            //清空堆
            size = 0;

            for (int i = 0; i < n; i++) {
                while (size > 0 && heap[0] <= intervals[i][0]) {
                    pop();
                }
                add(intervals[i][1]);
                ans = Math.max(ans, size);
            }

            return ans;
        }

        public static void add(int x) {
            heap[size] = x;
            int i = size++;
            while (heap[i] < heap[(i - 1) / 2]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public static void pop() {
            swap(0, --size);
            int i = 0, l = 1;
            while (l < size) {
                int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
                best = heap[best] < heap[i] ? best : i;
                if(best == i){
                    break;
                }
                swap(i, best);
                i = best;
                l = 2 * i + 1;
            }
        }

        public static void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

    }
}
