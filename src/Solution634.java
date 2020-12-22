/**
 * @author Yin
 * @date 2020/12/22
 */
public class Solution634 {
    public int findDerangement(int n) {
        if (n == 1) {
            return 0;
        }
        int mod = 1000000007;
        // dp[i]表示有i个数的时候的方案数
        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
            dp[i] %= mod;
        }
        return (int)dp[n];
    }
}
