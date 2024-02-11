package p2_arr.lc5_window;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">209. 长度最小的子数组</a>
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1; // [l ... r] 是滑动窗口
        int sum = 0;       // sum = 滑动窗口的和
        int res = nums.length + 1;

        // 窗口的左边界在数组范围内, 则循环继续
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) sum += nums[++r];
            else sum -= nums[l++];

            if (sum >= target) res = Math.min(res, r - l + 1);
        }

        return res != nums.length + 1 ? res : 0;
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1;         // [0 ... r] 是滑动窗口
        int[] freq = new int[256]; // freq[c] = 滑动窗口中字符 c 的频率
        int res = 0;

        // 窗口的左边界在字符串范围内, 则循环继续
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) freq[s.charAt(++r)]++;
            else freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/minimum-window-substring/description/">76. 最小覆盖子串</a>
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 目标
        int[] freq_t = new int[256];
        for (char c : t.toCharArray()) freq_t[c]++;

        // 窗口 [l ... r]
        int l = 0, r = -1;
        int[] freq_s = new int[256];
        int count = 0; // 窗口中包含 t 中字符的数量

        int startIndex = -1;
        int minLength = s.length() + 1;

        // 窗口的左边界在字符串范围内, 则循环继续
        while (l < s.length()) {
            if (r + 1 < s.length() && count < t.length()) {
                r++;
                char c = s.charAt(r);
                freq_s[c]++;
                if (freq_s[c] <= freq_t[c]) count++;
            } else {
                char c = s.charAt(l);
                freq_s[c]--;
                if (freq_s[c] < freq_t[c]) count--;
                l++;
            }

            if (count == t.length() && r - l + 1 < minLength) {
                startIndex = l;
                minLength = r - l + 1;
            }
        }

        if (startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLength);
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/">395. 至少有 K 个重复字符的最长子串</a>
     */
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for (int count = 1; count <= 26; count++) {
            if (s.length() < count) break;
            maxLen = Math.max(maxLen, longestSubstring(s, k, count));
        }
        return maxLen;
    }

    // 求符合条件的子字符串的最大长度
    // 不同字母的数量为 count, 每种字母出现的次数 >= k
    private int longestSubstring(String s, int k, int count) {
        int l = 0, r = -1;         // [0 ... r] 是滑动窗口
        int[] freq = new int[26];  // freq[c] = 滑动窗口中字符 c 的频率

        int maxLen = 0;            // 符合条件的子字符串的最大长度
        int hasCount = 0;          // 滑动窗口中包含的不同字母的数量

        // 窗口的左边界在字符串范围内, 则循环继续
        while (l < s.length()) {
            if (r + 1 < s.length() && hasCount <= count) {
                r++;
                char c = s.charAt(r);
                freq[c - 'a']++;
                if (freq[c - 'a'] == 1) hasCount++;
            } else {
                char c = s.charAt(l);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) hasCount--;
                l++;
            }

            if (hasCount == count && yes(freq, k)) maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    private boolean yes(int[] freq, int k) {
        for (int n : freq) {
            if (n != 0 && n < k) return false;
        }
        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/permutation-in-string/description/">567. 字符串的排列</a>
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq_s1 = new int[26];    // freq_s1 目标频率
        for (char c : s1.toCharArray()) freq_s1[c - 'a']++;

        int l = 0, r = s1.length() - 1; // [l ... r] 是滑动窗口
        int[] freq_s2 = new int[26];    // freq_s2[c] = 滑动窗口中字符 c 的频率

        for (int i = 0; i <= r; i++) freq_s2[s2.charAt(i) - 'a']++;
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

        for (int i = 0; i <= r; i++) freq_s[s.charAt(i) - 'a']++;
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
