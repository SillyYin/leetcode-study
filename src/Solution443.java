/**
 * 压缩字符串
 * @author Yin
 * @date 2020/10/27
 */
public class Solution443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int point = 0;
        int write = 0;
        for (int read = 0; read < chars.length; ++read) {
            // 如果下一个字符与当前read字符不相等或者到了最后一位的时候开始写入
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[point];
                if (read > point) {
                    for (char ch : String.valueOf(read - point + 1).toCharArray()) {
                        chars[write++] = ch;
                    }
                }
                point = read + 1;
            }
        }
        return write;
    }
}
