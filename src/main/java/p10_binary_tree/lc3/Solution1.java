package p10_binary_tree.lc3;

import help.tree.TreeNode;

/**
 * 二叉树构造篇
 */
@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/maximum-binary-tree/description/">654. 最大二叉树</a>
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;

        // 自顶向下构建
        int maxIndex = l;
        int maxValue = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);

        root.left = build(nums, l, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, r);

        return root;
    }
}
