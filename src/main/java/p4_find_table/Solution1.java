package p4_find_table;

import help.link.Node;

import java.util.*;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/valid-anagram/description/">242. 有效的字母异位词</a>
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/group-anagrams/description/">49. 字母异位词分组</a>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // encode : group
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String encode = encode(s);
            if (!map.containsKey(encode)) map.put(encode, new LinkedList<>());
            map.get(encode).add(s);
        }

        List<List<String>> res = new LinkedList<>();
        for (List<String> group : map.values()) res.add(group);
        return res;
    }

    private String encode(String s) {
        char[] freq = new char[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        return new String(freq);
    }

    /**
     * <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/">138. 随机链表的复制</a>
     */
    public Node copyRandomList(Node head) {
        // origin : clone
        HashMap<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) map.put(cur, new Node(cur.val));

        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
        }

        return map.get(head);
    }

    /**
     * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/description/">349. 两个数组的交集</a>
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);

        Set<Integer> res = new HashSet<>();
        for (int num : nums2) if (set.contains(num)) res.add(num);

        int[] arr = new int[res.size()];
        int i = 0;
        for (int num : res) arr[i++] = num;
        return arr;
    }

    /**
     * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/">350. 两个数组的交集 II</a>
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // num : freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new LinkedList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) != 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) arr[i++] = num;
        return arr;
    }
}
