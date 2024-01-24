package p1_link;

import help.link.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">21. 合并两个有序链表</a>
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode prev = dummyHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                prev.next = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        if (p1 == null) prev.next = p2;
        if (p2 == null) prev.next = p1;

        return dummyHead.next;
    }

    /**
     * <a href="https://leetcode.cn/problems/partition-list/description/">86. 分隔链表</a>
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode prev1 = dummyHead1; // 存放 <  x 的节点
        ListNode prev2 = dummyHead2; // 存放 >= x 的节点

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                prev1.next = cur;
                prev1 = prev1.next;
            } else {
                prev2.next = cur;
                prev2 = prev2.next;
            }
            cur = cur.next;
        }
        prev1.next = null; // 注意
        prev2.next = null; // 注意

        prev1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    /**
     * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) minHeap.add(head);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.remove();
            prev.next = node;
            prev = prev.next;
            if (node.next != null) minHeap.add(node.next);
        }

        return dummyHead.next;
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19. 删除链表的倒数第 N 个结点</a>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // 让 fast 向后移动 n + 1 次
        for (int i = 0; i < n + 1; i++) fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null; // 注意

        return head;
    }

    /**
     * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">876. 链表的中间结点</a>
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 1 -> 2 -> 3 -> 4 -> 5    返回 3
        // 1 -> 2 -> 3 -> 4 -> null 返回 3
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">141. 环形链表</a>
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">142. 环形链表 II</a>
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * <a href="https://www.yuque.com/u21488478/kb/gcfzrvwmz4oe7t96">160. 相交链表</a>
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }

        return p1;
    }
}
