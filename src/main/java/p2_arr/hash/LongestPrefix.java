package p2_arr.hash;

/**
 * <a href="https://leetcode.cn/problems/longest-happy-prefix/description/">1392. 最长快乐前缀</a>
 */
@SuppressWarnings("all")
public class LongestPrefix {

    private final long MOD = (long) (1e9 + 7);
    private final long B = 26;
    private long[] pow26;

    public String longestPrefix(String s) {
        // pow26[i] = (26 ^ i) % MOD
        pow26 = new long[s.length()];
        pow26[0] = 1;
        for (int i = 1; i < pow26.length; i++) pow26[i] = pow26[i - 1] * B % MOD;

        // prevHash[i] = hash(s[0 ... i])
        long[] prevHash = new long[s.length()];
        prevHash[0] = s.charAt(0) - 'a';
        for (int i = 1; i < prevHash.length; i++) {
            prevHash[i] = (prevHash[i - 1] * B + s.charAt(i) - 'a') % MOD;
        }

        // postHash[i] = hash(s[i ... s.length - 1])
        long[] postHash = new long[s.length()];
        postHash[postHash.length - 1] = s.charAt(s.length() - 1) - 'a';
        for (int i = postHash.length - 2; i >= 0; i--) {
            postHash[i] = ((s.charAt(i) - 'a') * pow26[s.length() - 1 - i] + postHash[i + 1]) % MOD;
        }

        for (int len = s.length() - 1; len >= 1; len--) {
            // s[0 ... len - 1] == s[s.length - len ... s.length - 1] ? 可能存在哈希冲突
            if (prevHash[len - 1] == postHash[s.length() - len] && equal(s, 0, len - 1, s.length() - len, s.length() - 1)) {
                return s.substring(0, len);
            }
        }

        return "";
    }

    // s[l1 ... r1] == s[l2 ... r2]
    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (; l1 <= r1 && l2 <= r2; l1++, l2++) {
            if (s.charAt(l1) != s.charAt(l2)) return false;
        }
        return true;
    }
}
