package p10_binary_tree.lc3;

import help.tree.TreeNode;

import java.util.HashMap;

/**
 * 二叉树构造篇
 */
@SuppressWarnings("all")
public class Solution4 {

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/">889. 根据前序和后序遍历构造二叉树</a>
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) valToIndex.put(postorder[i], i);
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    // l1 中左右 r1
    // l2 左右中 r2
    private TreeNode build(int[] preorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) return null;
        if (l1 == r1) return new TreeNode(preorder[l1]); // 注意

        // 自顶向下构建
        int rootVal = preorder[l1];
        TreeNode root = new TreeNode(rootVal);

        int leftRootVal = preorder[l1 + 1];
        int index = valToIndex.get(leftRootVal);
        int leftSize = index - l2 + 1;
        root.left = build(preorder, l1 + 1, l1 + leftSize, postorder, l2, index);
        root.right = build(preorder, l1 + leftSize + 1, r1, postorder, index + 1, r2 - 1);

        return root;
    }
}
