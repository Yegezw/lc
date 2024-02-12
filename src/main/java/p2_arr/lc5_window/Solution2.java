package p2_arr.lc5_window;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/permutation-in-string/description/">567. 字符串的排列</a>
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq_s1 = new int[26];    // freq_s1 目标频率
        for (char c : s1.toCharArray()) freq_s1[c - 'a']++;

        int l = 0, r = s1.length() - 1; // [l ... r] 是滑动窗口
        int[] freq_s2 = new int[26];    // freq_s2[c] = 滑动窗口中字符 c 的频率

        for (int i = l; i <= r; i++) freq_s2[s2.charAt(i) - 'a']++;
        if (same(freq_s1, freq_s2)) return true;

        while (true) {
            if (r == s2.length() - 1) break; // 窗口是否可以滑动

            r++;
            freq_s2[s2.charAt(r) - 'a']++;
            freq_s2[s2.charAt(l) - 'a']--;
            l++;
            if (same(freq_s1, freq_s2)) return true;
        }

        return false;
    }

    /**
     * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/">438. 找到字符串中所有字母异位词</a>
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) return res;

        int[] freq_p = new int[26];   // freq_p 目标频率
        for (char c : p.toCharArray()) freq_p[c - 'a']++;

        int l = 0, r = p.length() - 1; // [l ... r] 是滑动窗口
        int[] freq_s = new int[26];    // freq_s[c] = 滑动窗口中字符 c 的频率

        for (int i = l; i <= r; i++) freq_s[s.charAt(i) - 'a']++;
        if (same(freq_p, freq_s)) res.add(0);

        while (true) {
            if (r == s.length() - 1) break; // 窗口是否可以滑动

            r++;
            freq_s[s.charAt(r) - 'a']++;
            freq_s[s.charAt(l) - 'a']--;
            l++;
            if (same(freq_p, freq_s)) res.add(l);
        }

        return res;
    }

    private boolean same(int[] freq_p, int[] freq_s) {
        for (int i = 0; i < 26; i++) {
            if (freq_p[i] != freq_s[i]) return false;
        }
        return true;
    }
}
