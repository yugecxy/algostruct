package strucalgo.stack;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组实现方式：用一个变量用来记录当前栈顶元素的下标，当实现pop操作时，数组元素不会删除，只是栈顶的下标减1
 *
 * @author chenxiaoyu
 * @date  2018/05/01
 */
class Stack {
    int[] a;
    int capacity;
    int top;
    public Stack(int capacity) {
        a = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(int ele) {
        if (top == capacity) {
            throw new StackOverflowError();
        }
        a[++top]=ele;
    }

    public int top() {
        if (top == -1) {
            throw new Error("stack is empty");
        }
        return a[top];
    }

    public int pop() {
        if (top == -1) {
            throw new Error("stack is empty");
        }
        return a[top--];
    }

    public boolean isStackFull() {
        return (top==capacity-1);
    }

    public boolean isEmpty() {
        return (top==-1);
    }

    public int size() {
        return top+1;
    }

    public void deleteStack() {
        top=-1;
    }
}

public class ArrayImpStack {
    public static void main(String[] args) {
        List x=new ArrayList();
        Stack stack = new Stack(23);
        stack.push(4);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
    }

}
