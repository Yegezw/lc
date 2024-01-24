package p10_binary_tree.lc3;

import help.tree.TreeNode;

import java.util.HashMap;

/**
 * 二叉树构造篇
 */
@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) valToIndex.put(inorder[i], i);
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) return null;

        int rootVal = postorder[r2];
        TreeNode root = new TreeNode(rootVal);

        int index = valToIndex.get(rootVal);
        int leftSize = index - l1;
        root.left = build(inorder, l1, index - 1, postorder, l2, l2 + leftSize - 1);
        root.right = build(inorder, index + 1, r1, postorder, l2 + leftSize, r2 - 1);
        return root;
    }
}
