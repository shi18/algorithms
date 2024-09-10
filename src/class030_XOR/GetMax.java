package class030_XOR;

public class GetMax {
    //必须保证输入n为0或1
    //通过异或操作实现 0 变 1， 1 变 0。
    public static int flip(int n){
        return n ^ 1;
    }
    //非负数返回1
    //负数返回0
    //对于有符号类型整数，若为负数，最高位是1；若为正数，最高位为0
    // 右移运算符>>>在进行移位时，不管正数还是负数，前面补0，当右移31位后便只保留了符号位。
    public static int sign(int n){
        return flip(n >>> 31);
    }
    //比较大小实际理解位减法后结果为正数还是负数
    //当出现正数 - 负数 或 正数 - 负数 时，可能存在溢出情况
    public static int getMax(int a, int b){
        //c可能溢出
        int c = a - b;
        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);
        //判断A和B，符号是否一样，若不同，则diffAB = 1，若相同diffAB = 0；
        int diffAB = signA ^ signB;
        //判断A和B， 符号是否一样，若不同 sameAB = 0； 若相同sameAB = 1；
        int sameAB = flip(diffAB);
        //符号相同时，不会出现溢出情况，那么前半部分为0，后半分为为c的符号
        //若c为1，a>b，返回a*1，否则返回b
        //符号不同时，可能会溢出，后半部分为0，前半部分为a的符号
        //因为符号不同，若a为正数，那么a大，反之b大
        int returnA = diffAB * signA + sameAB * signC;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(b);
        // getMax方法永远正确
        System.out.println(getMax(a, b));
    }
}
