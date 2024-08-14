package class006_binarySearch;

public class findRightInSortedArray {
    public static int findRight(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0, ans = -1;
        while (l <= r) {
            m = l + (m - l) / 2;
            if (arr[m] <= num) {
                l = m + 1;
                ans = m;
            }
            if (arr[m] > num) {
                r = m - 1;
            }
        }
        return ans;
    }
}
