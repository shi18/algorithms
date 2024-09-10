package class030_XOR;
// 数组中有2种数出现了奇数次，其他的数都出现了偶数次
// 返回这2种出现了奇数次的数
// 测试链接 : https://leetcode.com/problems/single-number-iii/
public class DoubleNumber {
    public static int[] singleNUmber(int[] nums){
        // 得到的最终结果为 a ^ b 保存在xor中
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        //Brian Kernighan算法
        //提取最右面的1 n & (-n)
        int rightOne = xor & (-xor);
        int xorTwo = 0;
        for(int num : nums){
            if((num & rightOne) == 0){
                xorTwo ^= num;
            }
        }
        return new int[] {xorTwo, xorTwo ^ xor};
    }
}
