package xiaoyu.algostruct.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <a href="https://leetcode.cn/problems/jJ0w9p/">...</a>
 * 保留6位小数
 */
public class Sqrt {
    /**
     * 保留6位小数
     */
    public double mySqrt1(int x) {
        double left = 0;
        double right = x;
        double middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (middle * middle == x) {
                return middle;
            } else if (middle * middle < x) {
                left = middle + 0.000001;
            } else {
                right = middle - 0.000001;
            }
        }
        return new BigDecimal(middle).setScale(6, RoundingMode.HALF_UP).doubleValue();
    }
}
