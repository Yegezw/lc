package p10_binary_tree.lc3;

import help.tree.TreeNode;

import java.util.HashMap;

/**
 * 二叉树构造篇
 */
@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105. 从前序与中序遍历序列构造二叉树</a>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) valToIndex.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) return null;

        // 自顶向下构建
        int rootVal = preorder[l1];
        TreeNode root = new TreeNode(rootVal);

        int index = valToIndex.get(rootVal);
        int leftSize = index - l2;
        root.left = build(preorder, l1 + 1, l1 + leftSize, inorder, l2, index - 1);
        root.right = build(preorder, l1 + leftSize + 1, r1, inorder, index + 1, r2);

        return root;
    }
}
