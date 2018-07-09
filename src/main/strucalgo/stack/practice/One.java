package strucalgo.stack.practice;

import java.util.Stack;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/5/1
 * Desc:
 */
public class One {
    public static boolean isMatched(String raw) {
        char t;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < raw.length(); i++) {
            t = raw.charAt(i);
            if (t == '(') {
                stack.push('(');
            } else if (t == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(One.isMatched("d)a(l)kj)lj"));
    }
}
