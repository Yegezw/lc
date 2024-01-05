package p5_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/">225. 用队列实现栈</a>
 */
@SuppressWarnings("all")
public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // 321 4 -> 4 321
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
