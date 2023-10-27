package xiaoyu.algostruct.tag.permutation;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/IDBivT/">...</a>
 */
public class GenerateParenthesis {
    public static List<String> ret = new LinkedList<>();

    public static List<String> getAllSets(int n) {
        StringBuffer trace = new StringBuffer();
//        dfs(trace, 2 * n);
        dfs(new char[2 * n], 0);
        return ret;
    }

    public static void dfs(StringBuffer trace, int maxCnt) {
        if (trace.length() >= maxCnt) {
            if (isValid(trace.toString())) {
                ret.add(trace.toString());
            }
            return;
        }

        trace.append("(");
        dfs(trace, maxCnt);
        trace.deleteCharAt(trace.length() - 1);

        trace.append(")");
        dfs(trace, maxCnt);
        trace.deleteCharAt(trace.length() - 1);
    }

    public static void dfs(char[] trace, int pos) {
        if (pos >= trace.length) {
            if (isValid(new String(trace))) {
                ret.add(new String(trace));
            }
            return;
        }
        trace[pos] = '(';
        dfs(trace, pos + 1);

        trace[pos] = ')';
        dfs(trace, pos + 1);
    }

    public static boolean isValid(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                counter += 1;
            } else {
                counter -= 1;
            }
            if (counter < 0) {
                return false;
            }
        }
        return counter == 0;
    }

    public static void main(String[] args) {
        List<String> ret = getAllSets(3);
        System.out.println(ret.get(2));
    }
}
