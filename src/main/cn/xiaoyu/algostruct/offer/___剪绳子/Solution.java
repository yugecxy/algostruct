package xiaoyu.algostruct.offer.___剪绳子;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof/">...</a>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 */
public class Solution {
    public int cuttingRope(int n) {
        Map<Integer, Integer> trace = new HashMap<>();
        return dfs(n, trace);
    }

    public int dfs(int n, Map<Integer, Integer> trace) {
        if (n <= 1) return 1;
        if (trace.containsKey(n)) {
            return trace.get(n);
        }
        int max = 0;
        for (int i = 1; i <= n - 1; i++) {
            max = Math.max(Math.max(i * dfs(n - i, trace), i * (n - i)), max);
        }
        trace.put(n, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(8));
    }
}
