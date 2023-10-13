package xiaoyu.algostruct.offer;

/**
 * <a href="https://leetcode.cn/problems/ugly-number/">...</a>
 * 丑数就是只包含质因数 2、3 和 5 的正整数。给你一个整数 n ，请你判断 n是否为丑数（1也是丑数）。如果是，返回 true ；否则，返回 false
 */
public class UglyNum {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factorList = {5, 3, 2};
        for (int factor : factorList) {
            while (n % factor == 0) {
                n = n / factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNum().isUgly(3));
    }
}
