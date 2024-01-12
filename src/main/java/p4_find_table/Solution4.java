package p4_find_table;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Solution4 {

    /**
     * <a href="https://leetcode.cn/problems/set-mismatch/description/">645. 错误的集合</a>
     */
    public int[] findErrorNums(int[] nums) {
        // index in [0 ... n - 1]
        // value in [1 ... n]
        int n = nums.length;

        int dup = -1;
        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] > 0) nums[index] *= -1; // 值为 index + 1 的元素未出现过
            else dup = Math.abs(num);               // 值为 index + 1 的元素已出现过
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) missing = i + 1;       // 值为 i + 1 的元素未出现过
        }

        return new int[]{dup, missing};
    }

    /**
     * <a href="https://leetcode.cn/problems/find-all-duplicates-in-an-array/description/">442. 数组中重复的数据</a>
     */
    public List<Integer> findDuplicates(int[] nums) {
        // index in [0 ... n - 1]
        // value in [1 ... n]
        List<Integer> res = new LinkedList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] > 0) nums[index] *= -1; // 值为 index + 1 的元素未出现过
            else res.add(Math.abs(num));            // 值为 index + 1 的元素已出现过
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/">448. 找到所有数组中消失的数字</a>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // index in [0 ... n - 1]
        // value in [1 ... n]
        int n = nums.length;
        List<Integer> res = new LinkedList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] > 0) nums[index] *= -1; // 值为 index + 1 的元素未出现过
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res.add(i + 1);        // 值为 i + 1 的元素未出现过
        }

        return res;
    }
}
