package class025_HeapStructureAndHeapSort;

//https://leetcode.com/problems/sort-an-array/
public class HeapSort {
    public int[] sortArray(int[] arr) {
        heapSortOne(arr);
        return arr;
    }

    public static void heapSortOne(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            heapInsert(arr, i);
        }
        int size = n;
        while(size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapSortTwo(int[] arr) {
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--){
            heapify(arr, i, n);
        }
        int size = n;
        while(size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    //i位置的数，向上调整大根堆
    //arr[i] = x，x是新来的！往上看，直到不比父亲大，或者来到0位置(顶)
    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // i位置的数，变小了，又想维持大根堆结构
    // 向下调整大根堆
    // 当前堆的大小为size
    public static void heapify(int[] arr, int i, int size){
        int l = i * 2 + 1;
        while(l < size){
            // 有左孩子，l
            // 右孩子，l+1
            // 评选，最强的孩子，是哪个下标的孩子
            int best = (l + 1 < size && arr[l + 1] > arr[l]) ? l + 1 : l;
            // 上面已经评选了最强的孩子，接下来，当前的数和最强的孩子之间，最强下标是谁
            best = arr[best] > arr[i] ? best : i;
            //最强的是自己，那么就不用继续看自己的孩子哪个强了
            if(best == i){
                break;
            }
            // 和最强的孩子交换
            swap(arr, i, best);
            // 更新当前节点，然后继续和自己的孩子进行比较
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
