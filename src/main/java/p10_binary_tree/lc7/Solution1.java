package p10_binary_tree.lc7;

import help.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">103. 二叉树的锯齿形层序遍历</a>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        // true  ->
        // false <-
        boolean flag = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (flag) level.addLast(cur.val);
                else level.addFirst(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            list.add(level);
            flag = !flag;
        }

        return list;
    }

    /**
     * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/">124. 二叉树中的最大路径和</a>
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;
    }

    private int pathSum = Integer.MIN_VALUE;

    // 返回以 node 为端点的最大路径和
    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        // 当前节点有四个选择
        // 1、独立成线, 直接返回自己的值 
        // 2、跟左子节点合成一条路径 
        // 3、跟右子节点合成一条路径
        int ret = Math.max(node.val, node.val + Math.max(left, right));
        // 4、以自己为桥梁, 跟左、右子节点合并成一条路径
        pathSum = Math.max(pathSum, Math.max(ret, node.val + left + right));

        return ret;
    }

    /**
     * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">199. 二叉树的右视图</a>
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;

        if (depth == list.size()) list.add(node.val);

        dfs(node.right, depth + 1, list);
        dfs(node.left, depth + 1, list);
    }
}
