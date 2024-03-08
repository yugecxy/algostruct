package xiaoyu.algostruct.offer;

import java.util.Stack;

/**
 * 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否为该栈的弹出顺序
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int ele : pushed) {
            stack.push(ele);
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty() && j == popped.length;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 1, 2, 4, 5};
        System.out.println(new ValidateStackSequences().validateStackSequences(a, b));
    }
}
