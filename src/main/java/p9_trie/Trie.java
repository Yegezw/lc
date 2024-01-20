package p9_trie;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/description/">208. 实现 Trie (前缀树)</a>
 */
@SuppressWarnings("all")
public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}
