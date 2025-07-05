import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();// ✅ 创建对象
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());  // 输出 -3
        ms.pop();
        System.out.println(ms.top());     // 输出 0
        System.out.println(ms.getMin());  // 输出 -2
    }
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
