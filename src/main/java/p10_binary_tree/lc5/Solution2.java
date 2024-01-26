package p10_binary_tree.lc5;

import help.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化篇
 * <p><a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/">297. 二叉树的序列化与反序列化</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur != null) {
                    sb.append(cur.val).append(",");
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else sb.append("#").append(",");
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();

                String left = nodes[index++];
                if (!left.equals("#")) {
                    cur.left = new TreeNode(Integer.parseInt(left));
                    queue.add(cur.left);
                }

                String right = nodes[index++];
                if (!right.equals("#")) {
                    cur.right = new TreeNode(Integer.parseInt(right));
                    queue.add(cur.right);
                }
            }
        }

        return root;
    }
}
