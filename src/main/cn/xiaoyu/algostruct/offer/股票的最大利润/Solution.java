package xiaoyu.algostruct.offer.股票的最大利润;

/**
 * <a href="https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/">...</a>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minVal = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            result = Math.max(price - minVal, result);
            minVal = Math.min(price, minVal);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
