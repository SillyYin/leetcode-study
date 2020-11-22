import java.util.*;

/**
 * @author Yin
 * @date 2020/11/10
 */
@SuppressWarnings("all")
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        dist.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String top = queue.poll();
            for (int i = 0; i < top.length(); ++i) {
                char[] topChar = top.toCharArray();
                for (char j = 'a'; j <= 'z'; ++j) {
                    topChar[i] = j;
                    String temp = new String(topChar);
                    if (wordSet.contains(temp) && !dist.containsKey(temp)) {
                        dist.put(temp, dist.get(top) + 1);
                        if (temp.equals(endWord)) {
                            break;
                        }
                        queue.add(temp);
                    }
                }
            }
        }
        int ans = dist.getOrDefault(endWord, 0);
        return ans;
    }
}
