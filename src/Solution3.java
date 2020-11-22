import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author Yin
 * @date 2020/11/1
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int firstPoint = 0;
        int secondPoint = 0;
        int strLen = s.length();
        int ans = 1;
        Set<Character> containSet = new HashSet<>();
        char[] chars = s.toCharArray();
        while (firstPoint < strLen) {
            char ch = chars[firstPoint];
            ans = Math.max(ans, firstPoint - secondPoint);
            if (!containSet.contains(ch)) {
                containSet.add(ch);
                firstPoint++;
            } else {
                while (secondPoint < strLen && containSet.contains(ch)) {
                    containSet.remove(chars[secondPoint]);
                    secondPoint++;
                }
            }
        }
        ans = Math.max(ans, firstPoint - secondPoint);
        return ans;
    }
}
