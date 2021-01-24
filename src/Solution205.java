import java.util.*;

/**
 * @author Yin
 * @date 2020/12/27
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if ("".equals(s) && "".equals(t)) {
            return true;
        }
        if ("".equals(s) || "".equals(t)) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Set<Character> valueSet = new HashSet<>();

        for (int i = 0; i < len; ++i) {
            char sChar = sChars[i];
            char tChar = tChars[i];
            if (!map.containsKey(sChar)) {
                if (valueSet.contains(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
                valueSet.add(tChar);
            } else {
                char value = map.get(sChar);
                if (value != tChar) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        List<String> res = new ArrayList<>();
        for (char start = 'a'; start <= 'z'; start++) {
            res.add(String.valueOf(start));
        }
        for (int i = 0; i <= 9; ++i) {
            res.add(String.valueOf(i));
        }
        for (char i = 'A'; i <= 'Z'; ++i) {
            res.add(String.valueOf(i));
        }
        for (String s : res) {
            System.out.print("\"" + s + "\"" + ", ");
        }
    }
}
