package p3_str;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/reverse-string-ii/description/">541. 反转字符串 II</a>
     */
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // [i ... i + 2k - 1]
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k - 1, n - 1));
        }

        return new String(arr);
    }

    public String reverseStr2(String s, int k) {
        char[] arr = s.toCharArray();
        reverseStr2(arr, 0, k);
        return new String(arr);
    }

    // 递归反转 arr[l ...] 的前 k 个字符
    private void reverseStr2(char[] arr, int l, int k) {
        if (l >= arr.length - 1) return;

        int r = Math.min(l + k - 1, arr.length - 1);
        reverse(arr, l, r);

        reverseStr2(arr, l + 2 * k, k);
    }

    // 反转 arr[l ... r]
    private void reverse(char[] arr, int l, int r) {
        char temp;
        while (l < r) {
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/">151. 反转字符串中的单词</a>
     */
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");

        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            String word = arr[i];
            if (word == "") continue; // 注意
            sb.append(word);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * <a href="https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/description/">LCR 182. 动态口令</a>
     */
    public String dynamicPassword(String password, int target) {
        return password.substring(target) + password.substring(0, target);
    }

    public String dynamicPassword2(String password, int target) {
        char[] arr = password.toCharArray();

        int n = password.length();
        reverse(arr, 0, target - 1);
        reverse(arr, target, n - 1);
        reverse(arr, 0, n - 1);

        return new String(arr);
    }
}
