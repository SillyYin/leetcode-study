import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 移位字符串分组
 * 对字符串进行序列化操作，得到这个字符串中每个字符与其第一个字符之间的距离
 * @author Yin
 * @date 2020/10/26
 */
public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            char firstChar = str.charAt(0);
            for (char ch : str.toCharArray()) {
                sb.append("#");
                sb.append((ch - firstChar + 26) % 26);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
