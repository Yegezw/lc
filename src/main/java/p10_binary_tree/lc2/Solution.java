package p10_binary_tree.lc2;

import help.tree.Node;
import help.tree.TreeNode;

/**
 * 二叉树思路篇
 */
@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/invert-binary-tree/description/">226. 翻转二叉树</a>
     */
    public TreeNode invertTree1(TreeNode root) {
        order(root);
        return root;
    }

    private void order(TreeNode node) {
        if (node == null) return;

        // 自顶向下翻转
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        node.left = rightNode;
        node.right = leftNode;

        order(node.left);
        order(node.right);
    }

    public TreeNode invertTree2(TreeNode node) {
        if (node == null) return null;

        TreeNode leftRoot = invertTree2(node.left);
        TreeNode rightRoot = invertTree2(node.right);

        // 自底向上翻转
        node.left = rightRoot;
        node.right = leftRoot;

        return node;
    }

    /**
     * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/">116. 填充每个节点的下一个右侧节点指针</a>
     */
    public Node connect1(Node node) {
        if (node == null) return null;

        // 完美二叉树: left 存在则 right 也存在
        // 自顶向下填充 node.left.next 和 node.right.next
        if (node.left != null) {
            node.left.next = node.right;
            if (node.next != null) node.right.next = node.next.left;
            connect1(node.left);
            connect1(node.right);
        }

        return node;
    }

    public Node connect2(Node root) {
        if (root == null) return null;
        order(root.left, root.right);
        return root;
    }

    private void order(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;

        node1.next = node2;

        order(node1.left, node1.right);
        order(node2.left, node2.right);
        order(node1.right, node2.left);
    }

    /**
     * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/">114. 二叉树展开为链表</a>
     */
    public void flatten1(TreeNode node) {
        if (node == null) return;

        flatten1(node.left);
        flatten1(node.right);

        // 自底向上保持 "中左右"
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;

        node.left = null;
        node.right = leftNode;

        TreeNode last = node;
        while (last.right != null) last = last.right;
        last.right = rightNode;
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            // 自顶向下保持 "中左右"
            if (cur.left != null) {
                TreeNode prev = cur.left;
                while (prev.right != null) prev = prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
