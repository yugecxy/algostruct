package xiaoyu.algostruct.tag.双指针;

import java.util.Arrays;
import java.util.List;

/**
 * 接雨水
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class TrapRain {
    //双指针
    public int trapRain(List<Integer> buckets) {
        int i = 0;
        int j = buckets.size() - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(buckets.get(i), buckets.get(j)));
            if (buckets.get(i) < buckets.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TrapRain().trapRain(Arrays.asList(1, 4, 5, 2)));
    }
}
