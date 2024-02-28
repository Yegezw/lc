package p4_find_table;

import java.util.HashSet;
import java.util.TreeSet;

@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/">219. 存在重复元素 II</a>
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 窗口大小为 k + 1
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);

            // 保持 set 中最多有 k 个元素
            if (set.size() == k + 1) set.remove(nums[i - k]);
        }

        return false;
    }

    /**
     * <a href="https://leetcode.cn/problems/contains-duplicate-iii/description/">220. 存在重复元素 III</a>
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 窗口大小为 indexDiff + 1
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // [min ... num ... max]
            int num = nums[i];
            long min = num - valueDiff;
            long max = num + valueDiff;

            Long ceiling = set.ceiling(min);
            if (ceiling != null && ceiling <= max) return true;
            else set.add((long) num);

            // 保持 set 中最多有 indexDiff 个元素
            if (set.size() == indexDiff + 1) set.remove((long) nums[i - indexDiff]);
        }

        return false;
    }
}
