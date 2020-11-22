import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();
        char[] numChar = num.toCharArray();
        for (char ch : numChar) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > ch) {
                stack.pollLast();
                k--;
            }
            stack.add(ch);
        }

        // 数字从左到右是升序的情况
        while (!stack.isEmpty() && k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        String res = sb.reverse().toString();
        int index = 0;

        // 100这种
        while (index < res.length()) {
            if (res.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }

        return res.substring(index).equals("") ? "0":res.substring(index);
    }

    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        System.out.println(solution402.removeKdigits("10200", 1));
    }
}
