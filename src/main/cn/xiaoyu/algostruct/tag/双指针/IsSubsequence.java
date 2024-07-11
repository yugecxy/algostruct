package xiaoyu.algostruct.tag.双指针;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * 判断子序列。字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abe", "abcde"));
    }
}
