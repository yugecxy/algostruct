package xiaoyu.algostruct.offer;

/**
 * <a href="https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/">...</a>
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxPrice = Math.max(maxPrice, price - minPrice);
        }
        return maxPrice;
    }
}
