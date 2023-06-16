package xiaoyu.algostruct.tag.字符串.最长无重复子串;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">...</a>
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); //<char,index>
        int curLen = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                curLen += 1;
            } else {
                //更新curLen
                int dupIndex = map.get(c);
                curLen = Math.min(curLen + 1, i - dupIndex);
            }
            maxLen = Math.max(maxLen, curLen);
            map.put(c, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }
}
