package p14_dp.lc1_base.lc2;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-break/description/">139. 单词拆分</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict);
    }

    private int[] memo; // -1 0 1

    // 返回 wordDict 是否可以拼凑出 s[start ...]
    private boolean dp(String s, int start, List<String> wordDict) {
        if (start == s.length()) return true;

        if (memo[start] == -1) {
            String target = s.substring(start);
            boolean res = false;
            for (String prefix : wordDict) {
                if (target.startsWith(prefix)) {
                    if (dp(s, start + prefix.length(), wordDict)) res = true;
                }
            }
            memo[start] = res ? 1 : 0;
        }

        return memo[start] == 1;
    }
}
