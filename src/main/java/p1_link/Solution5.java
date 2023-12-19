package p1_link;

import com.zzw.practice2_linked_list.ListNode;

@SuppressWarnings("all")
public class Solution5 {

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // cur 是重复元素
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                cur = cur.next;
                if (cur == null) prev.next = null; // 注意
            } else {
                // cur 非重复元素
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
