package xiaoyu.algostruct.offer;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Math.max(len1, len2); i++) {
            int n1 = len1 - i >= 0 ? num1.charAt(len1 - i) - '0' : 0;
            int n2 = len2 - i >= 0 ? num2.charAt(len2 - i) - '0' : 0;
            int sum = n1 + n2 + add;
            sb.append(sum % 10);
            add = sum / 10;
        }
        if (add > 0) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
