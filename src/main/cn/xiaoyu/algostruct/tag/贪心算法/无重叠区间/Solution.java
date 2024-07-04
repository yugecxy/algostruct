package xiaoyu.algostruct.tag.贪心算法.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/">...</a>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = Integer.MIN_VALUE;
        int delCnt = 0;
        for (int[] interval : intervals) {
            if (interval[0] < end) {
                delCnt += 1;
                end = Math.min(end, interval[1]);
            } else {
                end = interval[1];
            }
        }
        return delCnt;
    }
}
