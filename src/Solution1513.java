/**
 * 仅含 1 的子串数
 * 一个连续全都是1的长度为k的字符串，有k*(k+1)/2个全是1的子字符串
 * @author Yin
 * @date 2020/10/28
 */
public class Solution1513 {
    public int numSub(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        long total = 0;
        final int MOD = 1000000007;
        char[] chars = s.toCharArray();
        int firstPoint = 0;
        while (firstPoint < chars.length) {
            // 用int的话，count可能会溢出导致结果错误
            long count = 0;
            while (firstPoint < chars.length && chars[firstPoint] == '1') {
                count++;
                firstPoint++;
            }
            firstPoint++;
            total += count * (count + 1) / 2;
            total %= MOD;
        }
        total %= MOD;
        return (int) total;
    }
}
