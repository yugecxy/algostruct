package xiaoyu.algostruct.tag.字符串.字符串相加;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">...</a>
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int up = 0;
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = a + b + up;
            int x = sum % 10;
            up = sum / 10;
            sb.append(x);
            i -= 1;
            j -= 1;
        }
        if (up > 0) {
            sb.append(up);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("3963", "456"));
    }
}
