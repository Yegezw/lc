package p2_arr.lc7_binary;

@SuppressWarnings("all")
public class Solution4 {

    /**
     * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/">153. 寻找旋转排序数组中的最小值</a>
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else l = mid + 1;
        }

        return nums[l];
    }

    /**
     * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/">154. 寻找旋转排序数组中的最小值 II</a>
     */
    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else if (nums[mid] > nums[r]) l = mid + 1;
            else r--;
        }

        return nums[l];
    }

    /**
     * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/description/">33. 搜索旋转排序数组</a>
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                if (nums[mid] < nums[l] && target > nums[r]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] > nums[r] && target < nums[l]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return -1;
    }

    /**
     * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/">81. 搜索旋转排序数组 II</a>
     */
    public boolean search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                if (nums[mid] < nums[l] && target > nums[r]) r = mid - 1;
                else if (nums[mid] == nums[l]) l++;
                else l = mid + 1;
            } else {
                if (nums[mid] > nums[r] && target < nums[l]) l = mid + 1;
                else if (nums[mid] == nums[r]) r--;
                else r = mid - 1;
            }
        }

        return false;
    }
}
