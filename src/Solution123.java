/**
 * @author Yin
 * @date 2020/12/17
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int status1 = 0;
        int status2 = -prices[0];
        int status3 = 0;
        int status4 = -prices[0];
        int status5 = 0;

        for (int i = 1; i < prices.length; ++i) {
            status2 = Math.max(status2, status1 - prices[i]);
            status3 = Math.max(status3, status2 + prices[i]);
            status4 = Math.max(status4, status3 - prices[i]);
            status5 = Math.max(status5, status4 + prices[i]);
        }
        return Math.max(Math.max(Math.max(status1, status2), Math.max(status3, status4)), status5);
    }
}
