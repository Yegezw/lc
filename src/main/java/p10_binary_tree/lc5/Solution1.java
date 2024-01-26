package p10_binary_tree.lc5;

import help.tree.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树序列化篇
 * <p><a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/">297. 二叉树的序列化与反序列化</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }

        sb.append(node.val).append(",");

        encode(node.left, sb);
        encode(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) nodes.add(node);
        return decode(nodes);
    }

    private TreeNode decode(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (first.equals("#")) return null; // 注意
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = decode(nodes);
        root.right = decode(nodes);
        return root;
    }
}
