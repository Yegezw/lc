package p3_str;

@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/add-strings/description/">415. 字符串相加</a>
     */
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        int temp = 0; // 进位
        while (p1 >= 0 || p2 >= 0) {
            int v1 = (p1 >= 0 ? num1.charAt(p1--) - '0' : 0);
            int v2 = (p2 >= 0 ? num2.charAt(p2--) - '0' : 0);
            int sum = v1 + v2 + temp;

            temp = sum / 10;
            sb.append(sum % 10);
        }
        if (temp != 0) sb.append(temp);

        return sb.reverse().toString();
    }
}
