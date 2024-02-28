package p6_queue.lc2_monotonic_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 通用单调队列
 */
@SuppressWarnings("all")
public class MonotonicQueue<E extends Comparable<E>> {

    private final Deque<E> deque;    // 常规队列: 存储所有元素
    private final Deque<E> minDeque; // 单调队列: 小 -> 大, 元素可以重复
    private final Deque<E> maxDeque; // 单调队列: 大 -> 小, 元素可以重复

    public MonotonicQueue() {
        deque    = new LinkedList<>();
        minDeque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public void push(E e) {
        deque.addLast(e);

        while (!minDeque.isEmpty() && minDeque.getLast().compareTo(e) > 0) minDeque.removeLast();
        minDeque.addLast(e);

        while (!maxDeque.isEmpty() && maxDeque.getLast().compareTo(e) < 0) maxDeque.removeLast();
        maxDeque.addLast(e);
    }

    public E min() {
        return minDeque.getFirst();
    }

    public E max() {
        return maxDeque.getFirst();
    }

    public E pop() {
        E del = deque.removeFirst();

        if (maxDeque.getFirst().compareTo(del) == 0) maxDeque.removeFirst();
        if (minDeque.getFirst().compareTo(del) == 0) minDeque.removeFirst();

        return del;
    }

    public int size() {
        return deque.size();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
