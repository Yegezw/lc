package p2_arr.lc8_rand;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/implement-rand10-using-rand7/">470. 用 Rand7() 实现 Rand10()</a>
 */
public class Solution3 {

    // 1 - 7
    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

    // --------------------- 解法一 ---------------------

    // 1 - 10
    public int rand10() {
        while (true) {
            int x = rand7() - 1; // x in 0 ~ 6
            int y = rand7() - 1; // y in 0 ~ 6
            int t = x * 7 + y;   // t in 0 ~ 48
            if (t >= 40) continue;
            return t % 10 + 1;
        }
    }

    // --------------------- 解法二 ---------------------

    // 0 - 1
    private int rand2() {
        int num = 4;
        while (num == 4) num = rand7();
        return num < 4 ? 0 : 1;
    }

    // 1 - 10
    public int rand10two() {
        int num;
        do {
            num = (rand2() << 3) + (rand2() << 2) + (rand2() << 1) + rand2() + 1; // 1 - 16
        } while (num > 10);
        return num;
    }
}
