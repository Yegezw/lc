package p4_find_table;

import java.util.*;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/majority-element/description/">169. 多数元素</a>
     */
    public int majorityElement(int[] nums) {
        int target = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                target = num;
                count = 1;
            } else if (num == target) {
                count++;
            } else {
                count--;
            }
        }

        return target;
    }

    /**
     * <a href="https://leetcode.cn/problems/happy-number/description/">202. 快乐数</a>
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (true) {
            if (n == 1) return true;
            if (seen.contains(n)) return false;
            seen.add(n);
            n = getNextNum(n);
        }
    }

    private int getNextNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    /**
     * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
     */
    public int[] twoSum(int[] nums, int target) {
        // value : index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            Integer index = map.get(needValue);
            if (index != null && index != i) return new int[]{i, index};
        }

        throw new RuntimeException("no solution!");
    }

    public int[] twoSum2(int[] nums, int target) {
        // value : index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (map.containsKey(needValue)) return new int[]{i, map.get(needValue)};
            else map.put(nums[i], i);
        }

        throw new RuntimeException("no solution!");
    }

    /**
     * <a href="https://leetcode.cn/problems/4sum-ii/description/">454. 四数相加 II</a>
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // sum : count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int k : nums3) {
            for (int j : nums4) {
                int sum = k + j;
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
    }

    /**
     * <a href="https://leetcode.cn/problems/number-of-boomerangs/description/">447. 回旋镖的数量</a>
     * <p>(i, j, k) 使得 distance(points[i], points[j]) == distance(points[i], points[k])
     */
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            // distance(points[i], points[x]) : count
            Map<Integer, Integer> map = new HashMap<>();

            for (int x = 0; x < points.length; x++) {
                if (x == i) continue;
                int distance = getDistance(points[i], points[x]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (int value : map.values()) {
                if (value >= 2) count += value * (value - 1);
            }
        }

        return count;
    }

    private int getDistance(int[] pointA, int[] pointB) {
        int xDiff = pointA[0] - pointB[0];
        int yDiff = pointA[1] - pointB[1];
        return xDiff * xDiff + yDiff * yDiff;
    }
}
