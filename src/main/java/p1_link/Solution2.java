package p1_link;

import help.link.ListNode;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode newHead = reverseList2(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }

    private ListNode successor;

    /**
     * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">92. 反转链表 II</a>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) return reverseN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 反转 "以 node 为头节点的链表" 中的前 n 个节点, 并返回新的头节点
    private ListNode reverseN(ListNode node, int n) {
        if (n == 1) {
            successor = node.next;
            return node;
        }

        ListNode newHead = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = successor;

        return newHead;
    }

    /**
     * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/">25. K 个一组翻转链表</a>
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // [a ... b) 包含 k 个待反转元素
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;   // 不足 k 个, 不需要反转
            b = b.next;
        }
        ListNode newHead = reverse(a, b); // 反转前 k 个元素

        a.next = reverseKGroup(b, k);     // 递归反转后续链表并连接起来
        return newHead;
    }

    // 反转 [head ... tail) 并返回新的头节点
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != tail) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
