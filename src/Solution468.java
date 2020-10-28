import java.util.Arrays;
import java.util.List;

/**
 * 验证IP地址
 * @author Yin
 * @date 2020/10/28
 */
public class Solution468 {
    public String validIPAddress(String IP) {
        if (IP == null || "".equals(IP)) {
            return "Neither";
        }

        if (judgeIPV4(IP)) {
            return "IPv4";
        }
        if (judgeIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean judgeIPV6(String ip) {
        final List<Character> rightChars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F');
        int count = 0;
        for (int i = 0; i < ip.length(); ++i) {
            if (ip.charAt(i) == ':') {
                count++;
            }
        }
        String[] splitIp = ip.split(":");
        if (splitIp.length != 8 || count != 7) {
            return false;
        }
        for (String item : splitIp) {
            if ("".equals(item)) {
                return false;
            }
            if (item.length() > 4) {
                return false;
            }
            char[] chars = item.toCharArray();
            for (char ch : chars) {
                if (!rightChars.contains(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean judgeIPV4(String ip) {
        int count = 0;
        for (int i = 0; i < ip.length(); ++i) {
            if (ip.charAt(i) == '.') {
                count++;
            }
        }
        final List<Character> rightChars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        // 注意.的切分
        String[] splitIp = ip.split("\\.");
        if (splitIp.length != 4 || count != 3) {
            return false;
        }
        for (String item : splitIp) {
            if ("".equals(item)) {
                return false;
            }
            if (item.charAt(0) == '0' && item.length() > 1) {
                return false;
            }
            char[] chars = item.toCharArray();
            for (char ch : chars) {
                if (!rightChars.contains(ch)) {
                    return false;
                }
            }
            // 字符串转成数组的时候一定要考虑为空的情况已经数据溢出的情况
            if (item.length() > 3 || Integer.parseInt(item) > 255) {
                return false;
            }
        }
        return true;
    }
}
