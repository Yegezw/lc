package p5_stack;

/**
 * <a href="https://leetcode.cn/problems/min-stack/description/">155. 最小栈</a>
 */
@SuppressWarnings("all")
public class MinStack {

    private class Node {
        public int val;
        public int min;
        public Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) head = new Node(val, val, null);
        else head = new Node(val, Math.min(head.min, val), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}