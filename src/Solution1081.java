import java.util.*;

/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution1081 {
    public String smallestSubsequence(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : charArray) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        for (char ch : charArray) {
            if (!stack.contains(ch)) {
                // 一个字符只有后面还存在的情况下才能考虑将其抛弃
                while (!stack.isEmpty() && stack.peekLast() > ch && map.get(stack.peekLast()) > 0) {
                    stack.pollLast();
                }
                stack.addLast(ch);
            }
            int count = map.get(ch);
            map.put(ch, count - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution1081 solution1081 = new Solution1081();
        System.out.println(solution1081.smallestSubsequence("cbacdcbc"));
    }
}
