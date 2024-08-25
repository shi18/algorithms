package class022_divideAndConquer;

//https://leetcode.com/problems/reverse-pairs/
public class ReversePair {
    class Solution {
        public static int MAXN = 50001;
        public static int[] help = new int[MAXN];

        public int reversePairs(int[] arr) {
            return reverseCount(arr, 0, arr.length - 1);
        }

        public int reverseCount(int[] arr, int l, int r) {
            if (l == r) {
                return 0;
            }
            int m = l + (r - l) / 2;
            return reverseCount(arr, l, m) + reverseCount(arr, m + 1, r) + merge(arr, l, m, r);
        }

        public int merge(int[] arr, int l, int m, int r) {
            long ans = 0;
            for (int i = l, j = m + 1; i <= m; i++) {
                while (j <= r && (long) arr[i] > (long) (2L * arr[j])) {
                    j++;
                }
                ans += j - m - 1;
            }
            //normal merge process
            int i = l, a = l, b = m + 1;
            while (a <= m && b <= r) {
                help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
            }
            while (a <= m) {
                help[i++] = arr[a++];
            }
            while (b <= r) {
                help[i++] = arr[b++];
            }
            for (i = l; i <= r; i++) {
                arr[i] = help[i];
            }
            return (int) ans;
        }
    }
}
