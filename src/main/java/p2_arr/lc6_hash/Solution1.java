package p2_arr.lc6_hash;

/**
 * <a href="https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/description/">1147. 段式回文</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    private final long MOD = (long) (1e9 + 7);
    private final int B = 26;
    private long[] pow26;

    public int longestDecomposition(String text) {
        // pow26[i] = (26 ^ i) % MOD
        pow26 = new long[text.length()];
        pow26[0] = 1;
        for (int i = 1; i < pow26.length; i++) pow26[i] = pow26[i - 1] * B % MOD;

        return solve(text, 0, text.length() - 1);
    }

    // text[left ... right]
    private int solve(String text, int left, int right) {
        if (left > right) return 0;

        long prevHash = 0; // text[left ... l]
        long postHash = 0; // text[r ... right]
        for (int l = left, r = right; l < r; l++, r--) {
            prevHash = (prevHash * B + text.charAt(l) - 'a') % MOD;
            postHash = ((text.charAt(r) - 'a') * pow26[right - r] + postHash) % MOD;

            // text[left ... l] == text[r ... right] ? 可能存在哈希冲突
            if (prevHash == postHash && equal(text, left, l, r, right)) return 2 + solve(text, l + 1, r - 1);
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
}
