package p1_link;

import help.link.ListNode;

@SuppressWarnings("all")
public class Solution4 {

    /**
     * <a href="https://leetcode.cn/problems/reorder-list/description/">143. 重排链表</a>
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next); // 注意
        slow.next = null;                    // 注意

        ListNode left = head;
        while (right != null) {
            ListNode left_temp = left.next;
            ListNode right_temp = right.next;
            left.next = right;
            right.next = left_temp;
            left = left_temp;
            right = right_temp;
        }
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
