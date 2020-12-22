/**
 * @author Yin
 * @date 2020/12/17
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int seller = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            seller = Math.max(seller, buy + prices[i]);
            buy = Math.max(buy, seller - prices[i]);
        }
        return seller;
    }
}
