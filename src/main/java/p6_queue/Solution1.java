package p6_queue;

import java.util.*;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/">1047. 删除字符串中的所有相邻重复项</a>
     */
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) deque.addLast(c);
            else {
                if (c != deque.getLast()) deque.addLast(c);
                else deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.removeFirst());
        return sb.toString();
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicate-letters/description/">316. 去除重复字母</a>
     */
    public String removeDuplicateLetters(String s) {
        // 统计每个字符 c 出现的频率
        char[] chars = s.toCharArray();
        int[] freq = new int[256];
        for (char c : chars) freq[c]++;

        Deque<Character> deque = new LinkedList<>();
        boolean[] inDeque = new boolean[256];

        // freq[] 存储的是: 未遍历字符的频率
        for (char c : chars) {
            freq[c]--;

            // c 已存在
            if (inDeque[c]) continue;

            // c 不存在
            char last;
            while (!deque.isEmpty() && (last = deque.getLast()) > c) {
                if (freq[last] == 0) break;
                deque.removeLast();
                inDeque[last] = false;
            }
            deque.addLast(c);
            inDeque[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.removeFirst());
        return sb.toString();
    }

    private class Node {
        public int num;
        public int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/top-k-frequent-elements/description/">347. 前 K 个高频元素</a>
     */
    public int[] topKFrequent(int[] nums, int k) {
        // num : count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // 根据次数来比较的最大堆
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((node1, node2) -> node2.count - node1.count);
        map.forEach((num, count) -> maxHeap.add(new Node(num, count)));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = maxHeap.remove().num;
        return res;
    }
}
