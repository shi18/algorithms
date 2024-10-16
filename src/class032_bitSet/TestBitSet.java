package class032_bitSet;

import class003_binaryIntro.BinaryIntro;

import java.util.Arrays;
import java.util.HashSet;

public class TestBitSet {
    public static void main(String[] args) {
        System.out.println("test start:");
        int n = 1000;
        int testTimes = 10000;
        BitSet bitSet = new BitSet(n);
        //use hashset as contrast test
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("call step begin");
        for(int i = 0; i < testTimes; i++){
            double decide = Math.random();
            int number = (int)(Math.random() * n);
            if(decide < 0.3333){
                bitSet.add(number);
                hashSet.add(number);
            } else if (decide < 0.6666) {
               bitSet.remove(number);
               hashSet.remove(number);
            }else {
                bitSet.reverse(number);
                if(hashSet.contains(number)){
                    hashSet.remove(number);
                }else{
                    hashSet.add(number);
                }
            }
        }
        System.out.println("hashset: " + hashSet);
        BinaryIntro.printIntBinary(bitSet.set[0]);
        System.out.println("call step end");
        System.out.println("validation start");

        for(int i = 0; i < n; i++){
            if(bitSet.contains(i) != hashSet.contains(i)){
                System.out.println("error");
            }
        }
        System.out.println(bitSet.contains(2));
        System.out.println("validation end");
        System.out.println("test end");
    }
}
