package class032_bitSet;
// 测试链接 : https://leetcode.com/problems/design-bitset/
public class DesignBitsetTest { // 位图的实现
// Bitset是一种能以紧凑形式存储位的数据结构
// Bitset(int n) : 初始化n个位，所有位都是0
// void fix(int i) : 将下标i的位上的值更新为1
// void unfix(int i) : 将下标i的位上的值更新为0
// void flip() : 翻转所有位的值
// boolean all() : 是否所有位都是1
// boolean one() : 是否至少有一位是1
// int count() : 返回所有位中1的数量
// String toString() : 返回所有位的状态
    class Bitset {
        private int[] set;
        private final int size;
        private int zero;
        private int one;
        private boolean reverse;
        public Bitset(int n) {
           set = new int[(n + 31) / 32];
           size = n;
           zero = n;
           one = 0;
           reverse = false;
        }

        public void fix(int idx) {
            int index= idx / 32;
            int bit = idx % 32;
            if(!reverse){
                //不反转，0->不存在, 1->存在
                if((set[index] & (1 << bit)) == 0){
                    zero--;
                    one++;
                    set[index] |= 1 << bit;
                }
            }else{
                //状态反转 0->存在  1->不存在
               if((set[index] & (1 << bit)) != 0){
                   zero--;
                   one++;
                    set[index] ^= 1 << bit;
               }
            }
        }

        public void unfix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if(!reverse){
                if((set[index] & (1 << bit)) != 0){
                    zero++;
                    one--;
                    set[index] ^= 1 << bit;
                }
            }else{
                if((set[index] & (1 << bit)) == 0){
                    zero++;
                    one--;
                    set[index] |= 1 << bit;
                }
            }
        }

        public void flip() {
            int tmp = zero;
            zero = one;
            one = tmp;
            reverse = !reverse;
        }

        public boolean all() {
            return zero == 0;
        }

        public boolean one() {
            return one > 0;
        }

        public int count() {
            return one;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0, k = 0, number, status; i < size; k++){
                number = set[k];
                for(int j = 0; j < 32 && i < size; j++, i++){
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    stringBuilder.append(status);
                }
            }
            return stringBuilder.toString();
        }
    }

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
}
