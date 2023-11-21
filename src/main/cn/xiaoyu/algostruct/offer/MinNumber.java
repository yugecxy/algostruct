package xiaoyu.algostruct.offer;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/">...</a>
 */
public class MinNumber {
    public String crackPassword(int[] password) {
        String[] strings = new String[password.length];
        int count = 0;
        for (int num : password) {
            strings[count++] = String.valueOf(num);
        }

        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        return String.join("", strings);
    }
}
