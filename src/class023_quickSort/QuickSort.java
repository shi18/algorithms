package class023_quickSort;

//https://leetcode.com/problems/sort-an-array/
public class QuickSort {

    public static void quickSortOne(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        int mid = partition(arr, l, r, x);
        quickSortOne(arr, 1, mid - 1);
        quickSortOne(arr, mid + 1, r);
    }

    public static int partition(int[] arr, int l, int r, int x) {
        int a = l, flag = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(arr, i, a);
                if (arr[a] == x) {
                    flag = a;
                }
                a++;
            }
        }
        swap(arr, flag, a - 1);
        return a - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int first, last;

    public static void quickSortTwo(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //随机拿到数组中的一个数字作为分水岭
        int x = arr[left + (int) (Math.random() * (right - left + 1))];
        partitionTwo(arr, left, right, x);

        int leftTmpBound = first;
        int rightTmpBound = last;
        // 已知arr[l....r]范围上一定有x这个值
        // 划分数组 <x放左边，==x放中间，>x放右边
        // 把全局变量first, last，更新成==x区域的左右边界
        quickSortTwo(arr, left, leftTmpBound - 1);
        quickSortTwo(arr, rightTmpBound + 1, right);
    }

    public static void partitionTwo(int[] arr, int left, int right, int x) {
        first = left;
        last = right;
        int i = left;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, first++, i++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr, last--, i);
            }
        }
    }
}
