package p9_trie;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/design-add-and-search-words-data-structure/description/">211. 添加与搜索单词 - 数据结构设计</a>
 */
@SuppressWarnings("all")
public class WordDictionary {

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

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    /**
     * <p>在以 node 为根节点的 Trie 中查找 word[index ... n - 1]
     * <p>node 中存放的是已经查询过的, 未查询的在 node 的下面
     */
    private boolean match(Node node, String word, int index) {
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);

        if (c != '.') {
            if (!node.next.containsKey(c)) return false;
            return match(node.next.get(c), word, index + 1);
        } else {
            for (Node nextNode : node.next.values()) {
                if (match(nextNode, word, index + 1)) return true;
            }
            return false;
        }
    }
}
