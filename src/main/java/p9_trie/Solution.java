package p9_trie;

/**
 * <a href="https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/">440. 字典序的第 K 小数字</a>
 */
public class Solution {

    public int findKthNumber(int n, int k) {
        // [1 ... n]
        // index = k - 1, 前面有 k - 1 个数需要跳过
        long count = k - 1;

        long prefix = 1;
        while (count > 0) {
            long size = getSize(prefix, n);

            if (size <= count) {
                count -= size;
                prefix++;
            } else {
                count -= 1;   // 跳过根节点
                prefix *= 10; // 进入下一层
            }
        }

        return (int) prefix;
    }

    // 计算 [prefix ... n] 中以 prefix 为前缀的节点数
    private long getSize(long prefix, long n) {
        long size = 0;

        long nextPrefix = prefix + 1;
        while (prefix <= n) {
            // 本层节点数
            long level = Math.min(nextPrefix - prefix, n - prefix + 1);
            size += level;
            // 进入下一层
            prefix *= 10;
            nextPrefix *= 10;
        }

        return size;
    }
}
