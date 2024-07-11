package xiaoyu.algostruct.tag.双指针;

/**
 * 如果一个字符串，短语正着读和反着读都一样，则可以认为该短语是一个回文串
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        return i > j;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("abccba"));
    }

}
