package class031_bitOperation;

public class PowerOfTwo {
    //https://leetcode.com/problems/power-of-two/
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && n == (n & -n)   ;
        }
    }
}
