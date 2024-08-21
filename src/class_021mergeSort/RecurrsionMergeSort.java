package class_021mergeSort;

public class RecurrsionMergeSort {
    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];

    public int[] mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (r - l) / 2 + l;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;

        while (a <= m && b <= r) {
            help[i++] = arr[a++] <= arr[b++] ? arr[a++] : arr[b++];
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
