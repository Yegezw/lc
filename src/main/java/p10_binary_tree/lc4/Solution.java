package p10_binary_tree.lc4;

import help.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序篇
 */
@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/find-duplicate-subtrees/description/">652. 寻找重复的子树</a>
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    private HashMap<String, Integer> subTree = new HashMap<>();
    private LinkedList<TreeNode> res = new LinkedList<>();

    private String serialize(TreeNode node) {
        if (node == null) return "#";

        String left = serialize(node.left);
        String right = serialize(node.right);

        String curNodeStr = left + "," + right + "," + node.val;
        int freq = subTree.getOrDefault(curNodeStr, 0);
        subTree.put(curNodeStr, freq + 1);
        if (freq == 1) res.add(node); // 注意

        return curNodeStr;
    }
}
