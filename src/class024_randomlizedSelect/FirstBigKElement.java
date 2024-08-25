package class024_randomlizedSelect;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class FirstBigKElement {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 第k大问题，转换为第 n - k 小的问题
            //[1, 2, 3, 5, 6], n = 5, k=3 第3大的数字
            //第2小，这里的2 对应index: 0, 1, 2，实际上是数组中第三个小的数字

            // System.out.println("ori arr: "+Arrays.toString(nums));
            return randomizedSelect(nums, nums.length - k);
        }

        public int randomizedSelect(int[] arr, int i){
            int ans = 0;

            for(int l = 0, r = arr.length - 1; l <= r;){
                int x = arr[l + (int)(Math.random() * (r - l + 1))];

                partition(arr, l, r, x);
                if(i < first){
                    r = first - 1;
                }else if(i > last){
                    l = last + 1;
                }else{
                    ans = arr[i];
                    break;
                }
            }
            return ans;
        }

        public static int first, last;

        public void partition(int[] arr, int l, int r, int x){
            first = l;
            last = r;

            int a = l;
            while (a <= last) {
                // System.out.println("old first: "+first+ " old last: "+last);
                if(arr[a] == x){
                    a++;
                }else if(arr[a] < x){
                    swap(arr, a++, first++);
                    // System.out.println("after swap: "+Arrays.toString(arr));
                }else{
                    swap(arr, a, last--);
                    // System.out.println("after swap: "+Arrays.toString(arr));
                }
                // System.out.println("first: "+first+ "  last: "+last);
            }

        }

        public static void swap(int[] arr, int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
