package p2_arr.lc1_two_point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/two-sum/description/">1. 两数之和</a>
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // 对 nums 的 "元素位置" 进行排序
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (o1, o2) -> Integer.compare(nums[o1], nums[o2]));

        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = nums[pos[l]] + nums[pos[r]];
            if (sum == target) return new int[]{pos[l], pos[r]};
            if (sum < target) l++;
            else r--;
        }

        return new int[]{-1, -1};
    }

    /**
     * <a href="https://leetcode.cn/problems/3sum/description/">15. 三数之和</a>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        // nums[i] <= nums[l] <= nums[r]
        // nums[i]  + nums[l]  + nums[r] = 0
        for (int i = 0; i + 2 < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 提前终止
            if (nums[i] > 0) break;

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int v1 = nums[l];
                int v2 = nums[r];
                int sum = nums[i] + v1 + v2;

                if (sum < 0) {
                    while (l < r && nums[l] == v1) l++;
                } else if (sum > 0) {
                    while (l < r && nums[r] == v2) r--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], v1, v2)));
                    while (l < r && nums[l] == v1) l++;
                    while (l < r && nums[r] == v2) r--;
                }
            }
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/4sum/description/">18. 四数之和</a>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        // nums[i] <= nums[j] <= nums[l] <= nums[r]
        // nums[i]  + nums[j]  + nums[l]  + nums[r] = target
        for (int i = 0; i + 3 < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 提前终止
            if ((long) nums[i] * 4 > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j + 2 < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 提前终止
                if ((long) nums[j] * 3 + nums[i] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long v1 = nums[l];
                    long v2 = nums[r];
                    long sum = nums[i] + nums[j] + v1 + v2;

                    if (sum < target) {
                        while (l < r && nums[l] == v1) l++;
                    } else if (sum > target) {
                        while (l < r && nums[r] == v2) r--;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], (int) v1, (int) v2)));
                        while (l < r && nums[l] == v1) l++;
                        while (l < r && nums[r] == v2) r--;
                    }
                }
            }
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/3sum-closest/description/">16. 最接近的三数之和</a>
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int diff = Integer.MAX_VALUE; // diff = target - sum

        // nums[i] + nums[l] + nums[r]
        for (int i = 0; i + 2 < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int v1 = nums[l];
                int v2 = nums[r];
                int sum = nums[i] + v1 + v2;
                if (Math.abs(target - sum) < Math.abs(diff)) diff = target - sum;

                if (sum < target) l++;
                else if (sum > target) r--;
                else return sum;
            }
        }

        return target - diff;
    }
}
