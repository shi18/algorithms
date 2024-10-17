package class033_bitOperationAddMinusMultiplyDivide;

import class003_binaryIntro.BinaryIntro;

public class BitOperationAddMinusMultiplyDivide {
    public static int MIN = Integer.MIN_VALUE;
    public int divide(int dividend, int divisor) {
        if(dividend == MIN && divisor == MIN){
            return 1;
        }
        if(dividend != MIN && divisor != MIN){
            return div(dividend,divisor);
        }
        if(divisor == MIN){
            return 0;
        }
        if(divisor == -1){
            return Integer.MAX_VALUE;
        }
        dividend= add(dividend, divisor > 0 ? divisor : neg(divisor));
        int ans = divide(dividend, divisor);
        int offset = divisor > 0 ? neg(1) : 1;
        return add(ans, offset);
    }
    public int add(int a, int b){
        int ans = a;
        while(b!=0){
           ans = a ^ b;
           b = (a & b) << 1;
           a = ans;
        }
        return ans;
    }

    public int minus(int a, int b){
        return add(a,neg(b));
    }

    public int neg(int n){
        return ~n + 1;
    }

    public int multiply(int a, int b){
        int ans = 0;
//        System.out.println("a and b listed below");
       // BinaryIntro.printIntBinary(a);
        // BinaryIntro.printIntBinary(b);
        while(b != 0){
            if((b & 1) != 0){
                ans = add(ans, a);
            //    System.out.println("new ans: ");
          //      BinaryIntro.printIntBinary(ans);
            }
           // System.out.println("a left shift 1");
            a <<= 1;
       //     BinaryIntro.printIntBinary(a);
            //System.out.println("b right shift 1");
            b >>>=1;
            // BinaryIntro.printIntBinary(b);
        }
        return ans;
    }

    public int div(int a, int b){
        int x = a >= 0 ? a : neg(a);
        int y = b >= 0 ? b : neg(b);
        int ans = 0;
        for(int i = 30; i >= 0; i = minus(i,1)){
            if((x >> i) >= y){
                ans |= 1 << i;
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

}
