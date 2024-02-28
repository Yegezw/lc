package p5_stack.lc1_stack;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/valid-parentheses/description/">20. 有效的括号</a>
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c != ')') return false;
                if (top == '[' && c != ']') return false;
                if (top == '{' && c != '}') return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/">150. 逆波兰表达式求值</a>
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) stack.push(Integer.parseInt(token));
            else {
                int v2 = stack.pop();
                int v1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(v1 + v2);
                        break;
                    case "-":
                        stack.push(v1 - v2);
                        break;
                    case "*":
                        stack.push(v1 * v2);
                        break;
                    case "/":
                        stack.push(v1 / v2);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
