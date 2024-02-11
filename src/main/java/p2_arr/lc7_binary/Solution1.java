package p2_arr.lc7_binary;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/binary-search/description/">704. 二分查找</a>
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }

    /**
     * <a href="https://leetcode.cn/problems/search-insert-position/description/">35. 搜索插入位置</a>
     */
    public int searchInsert(int[] nums, int target) {
        // 二分查找 >= target 的最小值
        int l = 0;
        int r = nums.length;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return r;
    }

    /**
     * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
     */
    public int[] searchRange(int[] nums, int target) {
        int l = searchL(nums, target);
        int r = searchR(nums, target);
        return new int[]{l, r};
    }

    private int searchL(int[] nums, int target) {
        // 二分查找 >= target 的最小值
        int l = 0;
        int r = nums.length;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return r != nums.length && nums[r] == target ? r : -1;
    }

    private int searchR(int[] nums, int target) {
        // 二分查找 <= target 的最大值
        int l = -1;
        int r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }

        return l != -1 && nums[l] == target ? l : -1;
    }
}
