package xiaoyu.algostruct.tag.repeat_num;

/**
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/">...</a>
 * 数组中出现次数超过一半的数字（求众数）
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int no = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                no = num;
                count += 1;
                continue;
            }
            count = no == num ? count + 1 : count - 1;
        }
        return no;
    }

}
