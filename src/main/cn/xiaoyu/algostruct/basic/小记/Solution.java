package xiaoyu.algostruct.basic.小记;

public class Solution {
    /**
     * 位数之和：给一个整数，求各位之和。如：123->6
     */
    public int getSumBySplitBit(int num) {
        int a = num;
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a = a / 10;
        }
        return sum;
    }

    /**
     * char和int互转
     */
    public void intToChar() {
        int a = '3' - '0'; //a = 3
        char ac = 3 + '0'; // ac = '3'

        int b = '3'; //ascii值
        char bc = 3; //ascii值为3的char

        int c = 4;
        char cc = (char) c; //使用变量需要强转
    }

    /**
     * 位运算
     */
    public void t() {
        //除以2/乘2
        int a = 4 >> 1;
        int b = 4 << 1;

        //取余
        int hash = 123145;
        int bin = hash & 10;
    }

    /**
     * 大小写转换
     */
    public void m() {

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSumBySplitBit(13));
    }
}
