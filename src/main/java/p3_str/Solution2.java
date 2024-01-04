package p3_str;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">28. 找出字符串中第一个匹配项的下标</a>
     */
    public int strStr(String s, String t) {
        if (t.isEmpty()) return 0;
        if (s.length() < t.length()) return -1;

        int[] lps = getLPS(t);
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
                if (tIndex == t.length()) return sIndex - t.length();
            }
            else if (tIndex > 0) tIndex = lps[tIndex - 1];
            else sIndex++;
        }

        return -1;
    }

    private int[] getLPS(String t) {
        int[] lps = new int[t.length()];

        for (int i = 1; i < lps.length; i++) {
            int a = lps[i - 1];
            while (a > 0 && t.charAt(a) != t.charAt(i)) a = lps[a - 1];
            if (t.charAt(a) == t.charAt(i)) lps[i] = a + 1;
        }

        return lps;
    }

    /**
     * <a href="https://leetcode.cn/problems/repeated-substring-pattern/description/">459. 重复的子字符串</a>
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int[] lps = getLPS(s);
        return lps[n - 1] != 0 && n % (n - lps[n - 1]) == 0; // ababab
    }
}
