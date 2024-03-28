package p7_structure;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/description/">146. LRU 缓存</a>
 */
@SuppressWarnings("all")
public class LRUCache {

    private final HashMap<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addLast(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addLast(node);
        } else {
            if (map.size() == capacity) {
                int del = removeFirst().key;
                map.remove(del);
            }

            Node node = new Node(key, value);
            addLast(node);
            map.put(key, node);
        }
    }

    // ---------------------------------------------------

    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private final Node dummyHead;
    private final Node dummyTail;

    private void addLast(Node node) {
        link(dummyTail.prev, node, dummyTail);
    }

    private Node removeFirst() {
        Node del = dummyHead.next;
        unLink(del.prev, del, del.next);
        return del;
    }

    private void remove(Node node) {
        unLink(node.prev, node, node.next);
    }

    private void link(Node prev, Node cur, Node next) {
        // prev <-> cur <-> next
        prev.next = cur;
        cur.prev = prev;
        cur.next = next;
        next.prev = cur;
    }

    private void unLink(Node prev, Node del, Node next) {
        // prev <-> del <-> next
        prev.next = next;
        next.prev = prev;
        del.prev = del.next = null;
    }
}
