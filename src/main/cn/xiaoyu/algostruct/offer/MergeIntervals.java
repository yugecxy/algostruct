package xiaoyu.algostruct.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/description/">...</a>
 */
public class MergeIntervals {
    public List<List<Integer>> merge(List<List<Integer>> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));
        List<List<Integer>> ret = new LinkedList<>();
        for (List<Integer> interval : intervals) {
            if (ret.isEmpty()) {
                ret.add(interval);
                continue;
            }
            int end = ret.get(ret.size() - 1).get(1);
            if (interval.get(1) <= end) {
                continue;
            }
            if (interval.get(0) > end) {
                ret.add(interval);
            } else {
                ret.get(ret.size() - 1).set(1, interval.get(1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = new LinkedList<>();
        intervals.add(Arrays.asList(1, 3));
        intervals.add(Arrays.asList(2, 4));
        intervals.add(Arrays.asList(8, 9));
        intervals.add(Arrays.asList(5, 7));
        intervals.add(Arrays.asList(9, 10));
        System.out.println(new MergeIntervals().merge(intervals));
    }
}
