package class031_bitOperation;

import class003_binaryIntro.BinaryIntro;

public class NearTwoPower {
// 已知n是非负数
// 返回大于等于n的最小的2某次方
// 如果int范围内不存在这样的数，返回整数最小值

    public static final int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        BinaryIntro.printIntBinary(n);
        n--;
        BinaryIntro.printIntBinary(n);

        n |= n >>> 1;
        BinaryIntro.printIntBinary(n);
        n |= n >>> 2;
        BinaryIntro.printIntBinary(n);
        n |= n >>> 4;
        BinaryIntro.printIntBinary(n);
        n |= n >>> 8;
        BinaryIntro.printIntBinary(n);
        n |= n >>> 16;
        BinaryIntro.printIntBinary(n);
        return n + 1;
    }

    public static void main(String[] args) {
        int number = 100;
        System.out.println(near2power(number));
    }
}
