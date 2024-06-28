package xiaoyu.algostruct.offer;

import java.util.Arrays;
import java.util.List;

/**
 * 接雨水
 */
public class TrapRain {
    //暴力/双指针
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
