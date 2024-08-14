package class006_binarySearch;

import java.util.Arrays;

public class FindNumInSortedArray {
    public static void main(String[] args) {
        //set array length
        int N = 100;
        //set element value range
        int V = 1000;
        //set number of tests
        int count = 10000;
        int n = (int) (Math.random() * N) + 1;
        System.out.println("test start: ");
        for(int i = 0;  i < count; i++){
            int[] arr = sortedArray(n, V);
            int num = (int) (Math.random() * V);
            if(bruteFindNum(arr, num) != findNum(arr, num)){
                System.out.println("wrong result");
            }
        }
        System.out.println("test end!");
    }

    //copy array to a new one.
    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        System.arraycopy(arr, 0, newArr, 0, n);
        return newArr;
    }

    //validate whether two array are same
    public static boolean validateResult(int[] arrOne, int[] arrTwo) {
        int n = arrTwo.length;
        for (int i = 0; i < n; i++) {
            if (arrOne[i] != arrTwo[i]) {
                return false;
            }
        }
        return true;
    }

    //generate random sorted array
    public static int[] sortedArray(int n, int V) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * V) + 1;
        }
        Arrays.sort(arr);
        return arr;
    }
    //brute force
    public static boolean bruteFindNum(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
    //binary search
    public static boolean findNum(int[]arr, int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        int l = 0, r = arr.length -1, m = 0;
        while(l <= r){
            m = l + ((r - l) >> 1);
            if(arr[m] == num){
                return true;
            }
            if(arr[m] < num){
                l = m +1;
            }
            if(arr[m] > num){
                r = m - 1;
            }
        }
        return false;
    }
}
