package class006_binarySearch;

public class FindLeftInSortedArray {
    public static int findLeft(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int l = 0, r = arr.length -1, m = 0, ans =-1;
        while(l <= r){
            m = l + ((r - l) >> 1);
            if(arr[m] < num){
                l = m +1;
            }
            if(arr[m] >= num){
                r = m -1;
                ans = m;
            }
        }
        return ans;
    }
}
