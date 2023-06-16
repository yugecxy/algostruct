package xiaoyu.algostruct.tag.字符串.最长回文字符串;

/**
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">...</a>
 */
public class Solution {
    public int calPalindrome(String s, int left, int right) {
        int len = right == left ? -1 : 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            len += 2;
        }
        return len;
    }

    public String longestPalindrome(String s) {
        int center = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenA = calPalindrome(s, i, i + 1);
            int lenB = calPalindrome(s, i, i);
            int curMax = Math.max(lenA, lenB);
            if (curMax > maxLen) {
                center = i;
                maxLen = curMax;
            }
        }
        if (maxLen % 2 == 0) {
            return s.substring(center - (maxLen / 2) + 1, center + (maxLen / 2) + 1);
        } else {
            return s.substring(center - (maxLen / 2), center + (maxLen / 2) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}
