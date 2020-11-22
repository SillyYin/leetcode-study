import java.util.*;

/**
 * @author Yin
 * @date 2020/11/10
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 在hash表里判断元素是否存在比直接在列表里判断速度要快
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        // 使用广搜构建一个图
        queue.add(beginWord);
        dist.put(beginWord, 0);
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

        // 使用深搜得到所有的结果
        path.add(endWord);
        dfs(res, path, beginWord, dist, endWord);
        return res;
    }

    private void dfs(List<List<String>> res, LinkedList<String> path, String beginWord, Map<String, Integer> dist, String word) {
        if (beginWord.equals(word)) {
            // 是从终点向起点遍历的，所以存储的时候需要存储翻转的结果
            Collections.reverse(path);
            res.add(new ArrayList<>(path));
            Collections.reverse(path);
            return;
        }

        for (int i = 0; i < word.length(); ++i) {
            char[] wordChar = word.toCharArray();
            for (char j = 'a'; j <= 'z'; ++j) {
                wordChar[i] = j;
                String temp = new String(wordChar);
                if (dist.containsKey(temp) && dist.get(temp) + 1 == dist.get(word)) {
                    path.add(temp);
                    dfs(res, path, beginWord, dist, temp);
                    path.removeLast();
                }
            }
        }
    }
}
