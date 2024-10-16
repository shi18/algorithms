package class032_bitSet;

public class BitSet {
    public  int[] set;
    public BitSet(int n){
        // 如果a/b的结果想向上取整，可以使用 （a + b -1）/b
        //前提是a和b都是非负数
        set = new int[(n + 31) / 32];
    }
    public void add(int num){
        set[num / 32] |= 1 << (num % 32);
    }
    public void remove(int num){
        set[num / 32] &= ~(1 << (num % 32));
    }
    public void reverse(int num){
        set[num / 32] ^= 1 << (num % 32);
    }
    public boolean contains(int num){
        boolean flag = ((set[num / 32] >> (num % 32)) & 1) == 1;
        return flag;
    }
}
