package class028_radixSortAndCountSort;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 3, 6};
        System.out.println("排序前： " + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("排序前： " + Arrays.toString(nums));
    }

    public static int first, last;

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) Math.random() * (r - l + 1)];
//        partition(arr, l, r, x);
//        int left = first;
//        int right = last;
//        quickSort(arr, l, first - 1);
//        quickSort(arr, last + 1, r);
        int[] flag = partition2(arr, l, r, x);
        quickSort(arr, l, flag[0] - 1);
        quickSort(arr, flag[1] + 1, r);
    }

    public static void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, i++, first++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr, i, last--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] partition2(int[] arr, int l, int r, int x) {
        int leftEnd = l;
        int rightStart = r;

        int i = l;
        while (i <= rightStart) {
            if (arr[i] < x) {
                swap(arr, i++, leftEnd++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr, i, rightStart--);
            }
        }
        int[] flag = {leftEnd, rightStart};
        return flag;
    }
}
