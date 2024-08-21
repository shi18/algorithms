package class_021mergeSort;

public class NonRecurionMergeSort {

    public static int MAX = 50001;
    public static int[] help = new int[MAX];

    public int[] mergeSort(int[] arr) {
        int n = arr.length;
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                //没有右半部分
                if (m >= n - 1) {
                    break;
                }
                //若有右半部分
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }

        return arr;
    }

    public void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
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
    }
}
