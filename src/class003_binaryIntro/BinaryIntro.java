package class003_binaryIntro;

public class BinaryIntro {
    // print byte type number with binary format
    public static void printByteBinary(byte num) {
        for (int i = 7; i >= 0; i--) {
            System.out.print((num & (((byte)1) << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    // print int type number with binary format
    public static void printIntBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    // print long type number with binary format
    public static void printLongBinary(long num) {
        for (int i = 63; i >= 0; i--) {
            System.out.print((num & (1L << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*print decimal number and binary number */
        byte a = 58;
        System.out.println("a is: " + a);
        printByteBinary(a);
        System.out.println("-------------");
        byte b = -89;
        System.out.println("b is: " + b);
        printByteBinary(b);
        System.out.println("-------------");

        /*write binary format directly*/
        byte c = 0b1001;
        System.out.println("c is: " + c);
        printByteBinary(c);
        System.out.println("-------------");

        /*write hexadecimal format directly*/
        byte d = 0x35;
        System.out.println("d is: " + d);
        printByteBinary(d);


        /*bitwise and & */
        System.out.println("-------bitwise and-------");
        printByteBinary(a);
        printByteBinary(b);
        printByteBinary((byte)(a & b));

        /*bitwise or | */
        System.out.println("-------bitwise or-------");
        printByteBinary(a);
        printByteBinary(b);
        printByteBinary((byte)(a | b));

        /*bitwise xor ^ */
        System.out.println("-------bitwise xor-------");
        printByteBinary(a);
        printByteBinary(b);
        printByteBinary((byte)(a ^ b));

        /*bitwise not ~ */
        System.out.println("-------bitwise not-------");
        printByteBinary(a);
        printByteBinary((byte)(~a));

        /*left shift << */
        System.out.println("-------left shift << -------");
        printByteBinary(a);
        printByteBinary((byte)(a << 2));

        /*right shift for positive value >>  */
        System.out.println("-------right shift for positive value-------");
        printByteBinary(a);
        printByteBinary((byte)(a >> 2));

        /*right shift for negative value >>  */
        int e = -42;
        System.out.println("-------right shift for negative value-------");
        printIntBinary(e);
        printIntBinary(e >> 2);
        printIntBinary(e >>> 2);

        printByteBinary(b);
        printByteBinary((byte)(b >> 2));
        printByteBinary((byte)(b >>> 2));

        /*logic and && */
        System.out.println("-------logic and &&-------");
        boolean testOne = returnFalse() && returnTrue();
        System.out.println("testOne result: " + testOne);
        System.out.println("-------bitwise and &-------");
        boolean testTwo= returnFalse() & returnTrue();
        System.out.println("testOne result: " + testTwo);

        /*logic or || */
        System.out.println("-------logic or ||-------");
        boolean testThree = returnTrue() || returnFalse();
        System.out.println("testThree result: " + testThree);
        System.out.println("-------bitwise or |-------");
        boolean testFour = returnTrue() | returnFalse();
        System.out.println("testFour result: " + testFour);

        // binary shift 1 vs divide by 2
        System.out.println(e >> 1);
        System.out.println(e / 2);

    }

    public static boolean returnTrue(){
        System.out.println("enter return True function");
        return true;
    }
    public static boolean returnFalse(){
        System.out.println("enter return False function");
        return false;
    }

}
