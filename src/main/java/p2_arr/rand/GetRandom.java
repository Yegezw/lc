package p2_arr.rand;

import com.zzw.practice2_linked_list.ListNode;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/linked-list-random-node/description/">382. 链表随机节点</a>
 */
public class GetRandom {

    private final ListNode head;
    private final Random random;

    public GetRandom(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * 蓄水池抽样: 蓄水池的大小为 1
     */
    public int getRandom() {
        int res = head.val;
        int index = 1;
        for (ListNode cur = head.next; cur != null; cur = cur.next, index++) {
            // random[0 ... index]
            int j = random.nextInt(index + 1);
            if (j == 0) res = cur.val;
        }
        return res;
    }
}
