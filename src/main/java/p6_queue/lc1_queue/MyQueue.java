package p6_queue.lc1_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">232. 用栈实现队列</a>
 */
@SuppressWarnings("all")
public class MyQueue {

    private Deque<Integer> stack1; // 入队
    private Deque<Integer> stack2; // 出队
    private int front;             // front 是 stack1 中最先进来的元素

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) front = x;
        stack1.push(x);
    }

    // [123 -> 123]
    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
