package p12_hui_su.lc1;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17. 电话号码的字母组合</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    private final String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits == null || digits.equals("")) return res;

        StringBuilder track = new StringBuilder(); // 路径
        backtrack(digits, 0, track);
        return res;
    }

    private void backtrack(String digits, int choice, StringBuilder track) {
        // 到达叶子节点, 将路径装入结果列表
        if (choice == digits.length()) {
            res.add(track.toString());
            return;
        }

        char c = digits.charAt(choice);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            track.append(letters.charAt(i));              // 做选择

            backtrack(digits, choice + 1, track);  // 进入下一层回溯树

            track.deleteCharAt(track.length() - 1); // 取消选择
        }
    }
}
