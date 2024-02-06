package p13_tan_xin.lc1;

@SuppressWarnings("all")
public class Solution5 {

    /**
     * <a href="https://leetcode.cn/problems/jump-game/description/">55. 跳跃游戏</a>
     */
    public boolean canJump(int[] nums) {
        int maxPos = 0;

        // i 作为起跳点, 能跳的最远格子为 i + nums[i]
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos == i) return false; // 不能往后跳了
        }

        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/jump-game-ii/description/">45. 跳跃游戏 II</a>
     */
    public int jump(int[] nums) {
        int count = 0;
        int curPos = 0;
        int maxPos = 0;

        // i 作为起跳点, 能跳的最远格子为 i + nums[i]
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == curPos) {
                count++;
                curPos = maxPos;
            }
        }

        return count;
    }
}
