package class007_complexity;

import java.util.Arrays;

import static class005_validator.ValidatorDemo.*;

public class ComplexityDemo {
    public static void main(String[] args) {
        //set array length
        int N = 200;
        //set array element range
        int V = 1000;
        //set number of tests
        int count = 10000;
        System.out.println("Test start: ");
        for (int i = 0; i < count; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            int[] arrOne = copyArray(arr);
            int[] arrTwo = copyArray(arr);

            bubbleSort(arrOne);
            bubbleSortWhile(arrTwo);

            if (!validateResult(arrOne, arrTwo)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arrOne));
                System.out.println(Arrays.toString(arrTwo));
                System.out.println("wrong result!");
            }
        }
        System.out.println("test end!");

        System.out.println("test start: ");
        int n = 500000000;
        long start, end;
        start = System.currentTimeMillis();
        harmonicSeries(n);
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间 : " + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        doubleForLoop(n);
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间 : " + (end - start) + " 毫秒");
    }

    //this code is to illustrate that you cannot get complexity by just look at how many times of the loop,
    //in this code, it only used a while loop, it is not O(N) time complexity
    //it is a O(N^2) complexity algorithm.
    public static void bubbleSortWhile(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int end = n - 1, i = 0;
        while (end > 0) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
            if (i < end - 1) {
                i++;
            } else {
                end--;
                i = 0;
            }
        }
    }

    public static void harmonicSeries(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                //time complexity O(Nlog(N))
                //format of harmonicSeries
            }
        }
    }

    public static void doubleForLoop(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //time complexity O(N^2)
            }
        }
    }
}
