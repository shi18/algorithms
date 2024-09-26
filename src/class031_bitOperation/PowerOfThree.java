package class031_bitOperation;
//https://leetcode.com/problems/power-of-three/
public class PowerOfThree {
    class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }
}
