package xiaoyu.algostruct.tag.str_match;

/**
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">...</a>
 * 计算字符串出现的第一个位置
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            //循环比较
            int k = i;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            if (j == needle.length()) {
                return k;
            }
            i = k + 1;
            j = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("mississippi", "issip"));
    }
}
