package p11_binart_search_tree.lc3;

/**
 * 二叉搜索树构造篇
 */
@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">96. 不同的二叉搜索树</a>
     */
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int[][] memo;

    // 返回用 [l ... r] 组成的 BST 个数
    private int count(int l, int r) {
        if (l > r) return 1; // 注意

        if (memo[l][r] == 0) {
            int res = 0;
            for (int i = l; i <= r; i++) {
                // root 的值为 i
                int left = count(l, i - 1);
                int right = count(i + 1, r);

                // 左子树的组合数 × 右子树的组合数 = BST 总数
                res += left * right;
            }
            memo[l][r] = res;
        }

        return memo[l][r];
    }
}
