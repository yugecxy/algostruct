package xiaoyu.algostruct.offer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
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
}
