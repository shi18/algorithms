package class006_binarySearch;

public class findPeak {
    // 测试链接 : https://leetcode.com/problems/find-peak-element/
    class Solution {
        public static int findPeakElement(int[] arr) {
            int n = arr.length;
            if(arr.length == 1){
                return 0;
            }
            if (arr[0] > arr[1]) {
                return 0;
            }
            if (arr[n - 1] > arr[n - 2]) {
                return n - 1;
            }
            int l = 1, r = n - 2, m = 0, ans = -1;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (arr[m - 1] > arr[m]) {
                    r = m - 1;
                } else if (arr[m] < arr[m + 1]) {
                    l = m + 1;
                } else {
                    ans = m;
                    break;
                }

            }
            return ans;
        }
    }
}
