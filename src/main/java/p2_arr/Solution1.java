package p2_arr;

import java.util.Arrays;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/">26. 删除有序数组中的重复项</a>
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // [0 ... slow] 无重复
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) nums[++slow] = nums[fast++];
            else fast++;
        }

        return slow + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-element/description/">27. 移除元素</a>
     */
    public int removeElement(int[] nums, int val) {
        // [0 ... slow) != val
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) nums[slow++] = nums[fast++];
            else fast++;
        }

        return slow;
    }

    /**
     * <a href="https://leetcode.cn/problems/move-zeroes/">283. 移动零</a>
     */
    public void moveZeroes(int[] nums) {
        // [0 ... slow) != 0
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) nums[slow++] = nums[fast++];
            else fast++;
        }
        Arrays.fill(nums, slow, nums.length, 0);
    }

    /**
     * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">167. 两数之和 II - 输入有序数组</a>
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum < target) left++;
            else right--;
        }

        return new int[]{-1, -1};
    }

    /**
     * <a href="https://leetcode.cn/problems/reverse-string/description/">344. 反转字符串</a>
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">977. 有序数组的平方</a>
     */
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i = arr.length - 1;

        // 合并两个降序数组, 得到一个升序数组
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[i--] = nums[left] * nums[left];
                left++;
            } else {
                arr[i--] = nums[right] * nums[right];
                right--;
            }
        }

        return arr;
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">5. 最长回文子串</a>
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i + 1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else break;
        }
        return s.substring(l + 1, r);
    }

    /**
     * <a href="https://leetcode.cn/problems/advantage-shuffle/description/">870. 优势洗牌</a>
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 对 nums2 的 "元素位置" 进行排序
        Integer[] pos = new Integer[nums2.length];
        for (int i = 0; i < pos.length; i++) pos[i] = i;
        Arrays.sort(pos, (o1, o2) -> Integer.compare(nums2[o1], nums2[o2]));

        Arrays.sort(nums1);
        int left = 0;                 // min = nums1[left]
        int right = nums1.length - 1; // max = nums1[right]

        for (int i = pos.length - 1; i >= 0; i--) {
            int maxPos = pos[i];
            if (nums1[right] > nums2[maxPos]) nums2[maxPos] = nums1[right--];
            else nums2[maxPos] = nums1[left++];
        }
        return nums2;
    }
}
