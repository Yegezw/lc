package p4_find_table;

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
