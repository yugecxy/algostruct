package xiaoyu.algostruct.offer.___丑数;

/**
 * <a href="https://leetcode.cn/problems/ugly-number/">...</a>
 * 丑数就是只包含质因数 2、3 和 5 的正整数。给你一个整数 n ，请你判断 n是否为丑数。如果是，返回 true ；否则，返回 false
 */
public class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n <= 6) return true;

        if (n % 2 == 0) return isUgly(n / 2);
        if (n % 3 == 0) return isUgly(n / 3);
        if (n % 5 == 0) return isUgly(n / 5);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(8));
    }
}
