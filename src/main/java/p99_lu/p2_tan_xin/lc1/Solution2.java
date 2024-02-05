package p99_lu.p2_tan_xin.lc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/partition-labels/description/">763. 划分字母区间</a>
     */
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        // 统计每一个字符的最远下标
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // end = 已遍历字符 s[0 ... i] 的最远下标
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/gas-station/description/">134. 加油站</a>
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int sum = 0;
        int minSum = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            // 经过第 i 个站点后 sum 到达新低
            // 所以站点 i + 1 就是最低点(起点)
            if (sum < minSum) {
                minSum = sum;
                minIndex = i + 1;
            }
        }

        if (sum < 0) return -1; // 总油量 < 总消耗, 无解
        return minIndex == n ? 0 : minIndex;
    }

    /**
     * <a href="https://leetcode.cn/problems/candy/description/">135. 分发糖果</a>
     */
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 左规则: 左小给右多
        for (int i = 0; i + 1 < ratings.length; i++) {
            if (ratings[i] < ratings[i + 1]) left[i + 1] = left[i] + 1;
        }
        // 右规则: 右小给左多
        for (int i = ratings.length - 1; i - 1 >= 0; i--) {
            if (ratings[i] < ratings[i - 1]) right[i - 1] = right[i] + 1;
        }

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
