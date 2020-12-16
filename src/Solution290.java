import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yin
 * @date 2020/12/16
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] patternChar = pattern.toCharArray();
        String[] words = s.split(" ");
        Set<String> wordSet = new HashSet<>();
        if (patternChar.length != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; ++i) {
            char ch = patternChar[i];
            String word = words[i];
            if (!map.containsKey(ch)) {
                map.put(ch, word);
                if (wordSet.contains(word)) {
                    return false;
                }
                wordSet.add(word);
            } else {
                if (!word.equals(map.get(ch))) {
                    return false;
                }
            }
        }
        return true;
    }
}
