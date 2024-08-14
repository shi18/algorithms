package class005_validator;

import java.util.Arrays;

public class ValidatorDemo {
    public static void main(String[] args) {
        //set length of arr
        int N = 200;
        //set range of value of the arr element
        int V = 3000;
        //set number of tests
        int count = 10000;

        System.out.println("test start: ");
        for (int i = 0; i < count; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            int[] selectionArr = copyArray(arr);
            int[] bubbleArr = copyArray(arr);
            int[] insertionArr = copyArray(arr);

            selectionSort(selectionArr);
            bubbleSort(bubbleArr);
            insertionSort(insertionArr);

            if (!validateResult(selectionArr, bubbleArr) || !validateResult(selectionArr, insertionArr)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(selectionArr));
                System.out.println(Arrays.toString(bubbleArr));
                System.out.println(Arrays.toString(insertionArr));
                System.out.println("wrong result!");
            }
        }
        System.out.println("test end!");
    }

    public static int[] randomArray(int n, int V) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * V) + 1;
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static boolean validateResult(int[] arrOne, int[] arrTwo) {
        int n = arrOne.length;
        for (int i = 1; i < n; i++) {
            if (arrOne[i] != arrTwo[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
