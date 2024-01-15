package p6_queue.pq;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/">295. 数据流的中位数</a>
 */
@SuppressWarnings("all")
public class MedianFinder {

    private final PriorityQueue<Integer> large; // 小顶堆
    private final PriorityQueue<Integer> small; // 大顶堆

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (large.size() >= small.size()) {
            large.add(num);
            small.add(large.remove());
        } else {
            small.add(num);
            large.add(small.remove());
        }
    }

    public double findMedian() {
        if (large.size() > small.size()) return large.peek();
        if (large.size() < small.size()) return small.peek();
        return (large.peek() + small.peek()) / 2.0;
    }
}
