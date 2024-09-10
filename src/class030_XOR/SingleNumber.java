package class030_XOR;
//https://leetcode.com/problems/single-number/submissions/1385210538/
public class SingleNumber {
    public static int singleNumber(int[] nums){
        int xor = 0;
        for(int num :nums){
            xor ^= num;
        }
        return xor;
    }
}
