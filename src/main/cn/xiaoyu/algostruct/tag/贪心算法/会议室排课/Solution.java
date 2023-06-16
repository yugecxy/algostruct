package xiaoyu.algostruct.tag.贪心算法.会议室排课;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode-cn.com/problems/meeting-rooms-ii/">...</a>
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 */
public class Solution {
    public int minMeetingRooms(List<List<Integer>> intervals) {
        intervals.sort(Comparator.comparing(a -> a.get(0)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (List<Integer> interval : intervals) {
            int beginTime = interval.get(0);
            int endTime = interval.get(1);
            if (minHeap.isEmpty()) {
                minHeap.offer(endTime);
                continue;
            }
            if (beginTime >= minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(endTime);
            } else {
                minHeap.offer(endTime);
            }
        }

        return intervals.size();
    }
}
