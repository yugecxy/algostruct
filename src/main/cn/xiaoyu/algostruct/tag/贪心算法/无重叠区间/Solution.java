package xiaoyu.algostruct.tag.贪心算法.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/">...</a>
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        int curEnd = Integer.MAX_VALUE;
        int delCnt = -1;
        for (int[] interval : intervals) {
            int begin = interval[0];
            int end = interval[1];
            if (begin >= curEnd) {
                curEnd = end;
                continue;
            }
            curEnd = Math.min(curEnd, end);
            delCnt += 1;
        }
        return delCnt;
    }
}
