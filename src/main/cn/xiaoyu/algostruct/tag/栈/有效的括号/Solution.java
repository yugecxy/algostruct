package xiaoyu.algostruct.tag.栈.有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
