package class030_XOR;
//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
    public static int missingNumber(int[] nums){
        int xorAll = 0, xorHas = 0;
        for (int i = 0; i < nums.length; i++){
            //将 0 - n 中每个数字异或
            xorAll ^= i;
            //将数组中的所有数字异或
            xorHas ^= nums[i];
        }
        //异或上n+1这个数字
        xorAll ^= nums.length;
        //根据异或法则，重复出现的数字异或之后为0，剩下的数字就是只出现了一次的数字，即缺失的数字。
        return xorAll ^ xorHas;
    }
}
