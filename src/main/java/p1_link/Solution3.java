package p1_link;

import help.link.ListNode;

@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">203. 移除链表元素</a>
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) prev.next = prev.next.next;
            else prev = prev.next;
        }

        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val != val ? head : head.next;
    }

    /**
     * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">24. 两两交换链表中的节点</a>
     */
    public ListNode swapPairs1(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode dummyHead = new ListNode(-1, node);

        //     p        1    2    n
        // dummyHead -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // dummyHead -> 2 -> 1 -> 4 -> 3 -> 6 -> 5
        ListNode prev = dummyHead;
        ListNode node1 = node;
        ListNode node2 = node.next;
        ListNode next;
        while (node1 != null && node2 != null) {
            next = node2.next;
            node2.next = node1;
            node1.next = next;
            prev.next = node2;

            prev = node1;
            node1 = next;
            if (node1 != null) node2 = node1.next;
        }

        return dummyHead.next;
    }

    public ListNode swapPairs2(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode node1 = node;
        ListNode node2 = node.next;
        ListNode newHead = swapPairs2(node2.next);

        node2.next = node1;
        node1.next = newHead;

        return node2;
    }

    public ListNode left;

    /**
     * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/">234. 回文链表</a>
     */
    public boolean isPalindrome1(ListNode head) {
        left = head;
        return postOrder(head);
    }

    private boolean postOrder(ListNode right) {
        if (right == null) return true;

        boolean res = postOrder(right.next);

        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

    // 非递归
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
