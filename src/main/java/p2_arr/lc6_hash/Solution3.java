package p2_arr.lc6_hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences/description/">187. 重复的 DNA 序列</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    /**
     * 滚动哈希, 4 进制
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();

        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        int[] map = new int[256];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        int B = 4;        // 4 进制

        int hash = 0;     // hash(s[0 ... 8])
        for (int i = 0; i <= 8; i++) hash = hash * B + map[s.charAt(i)];
        int P = 1;        // P = B ^ 9
        for (int i = 0; i < 9; i++) P = P * B;

        // s[i - 9 ... i]
        for (int i = 9; i < s.length(); i++) {
            hash = hash * B + map[s.charAt(i)];
            if (seen.contains(hash)) res.add(s.substring(i - 9, i + 1));
            else seen.add(hash);
            hash -= map[s.charAt(i - 9)] * P;
        }

        return new ArrayList<>(res);
    }
}
