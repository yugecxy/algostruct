package xiaoyu.algostruct.offer.栈的压入和弹出序列;

import java.util.Stack;

/**
 *
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(
                new int[]{0, 1},
                new int[]{0, 1}
        ));
    }
}
