package xiaoyu.algostruct.tag.binarysearch.平方根;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <a href="https://leetcode.cn/problems/jJ0w9p/">...</a>
 * 保留6位小数
 */
public class Solution {
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

    /**
     * 保留整数（直接把小数去掉）
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int middle = (left + right) / 2;
            if ((long) middle * middle <= x) {
                if((long)(middle+1)*(middle+1) >x){
                    return middle;
                }
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2));
    }
}
