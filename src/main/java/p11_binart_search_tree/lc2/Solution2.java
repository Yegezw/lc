package p11_binart_search_tree.lc2;

import help.tree.TreeNode;

/**
 * 二叉搜索树基操篇
 */
@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/">700. 二叉搜索树中的搜索</a>
     */
    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null) return null;

        if (val == node.val) return node;
        if (val < node.val) return searchBST(node.left, val);
        return searchBST(node.right, val);
    }

    /**
     * <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/">701. 二叉搜索树中的插入操作</a>
     */
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        if (val < node.val) node.left = insertIntoBST(node.left, val);
        else if (val > node.val) node.right = insertIntoBST(node.right, val);

        return node;
    }

    /**
     * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450. 删除二叉搜索树中的节点</a>
     */
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) return null;

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                return rightNode;
            } else if (node.right == null) {
                TreeNode leftNode = node.left;
                node.left = null;
                return leftNode;
            } else {
                TreeNode successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
