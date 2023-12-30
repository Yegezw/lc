package p2_arr.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/description/">1147. 段式回文</a>
     */
    public int longestDecomposition(String text) {
        return solve(text, 0, text.length() - 1);
    }

    // text[left ... right]
    private int solve(String text, int left, int right) {
        if (left > right) return 0;

        for (int l = left, r = right; l < r; l++, r--) {
            // s[left ... l] == s[r ... right] ?
            if (equal(text, left, l, r, right)) return 2 + solve(text, l + 1, r - 1);
        }

        return 1;
    }

    // text[l1 ... r1] == text[l2 ... r2]
    private boolean equal(String text, int l1, int r1, int l2, int r2) {
        for (; l1 <= r1 && l2 <= r2; l1++, l2++) {
            if (text.charAt(l1) != text.charAt(l2)) return false;
        }
        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-happy-prefix/description/">1392. 最长快乐前缀</a>
     */
    public String longestPrefix(String s) {
        // s[0 ... len - 1] == s[s.length - len ... s.length - 1] ?
        for (int len = s.length() - 1; len >= 1; len--) {
            if (equal(s, 0, len - 1, s.length() - len, s.length() - 1)) return s.substring(0, len);
        }
        return "";
    }

    /**
     * <a href="https://leetcode.cn/problems/repeated-dna-sequences/description/">187. 重复的 DNA 序列</a>
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        // s[i ... i + 9]
        for (int i = 0; i + 9 < s.length(); i++) {
            String key = s.substring(i, i + 10);
            if (seen.contains(key)) res.add(key);
            else seen.add(key);
        }

        return new ArrayList<>(res);
    }
}
