/**
 * @author yinrongjie
 * @version 1.0
 * @description 爱生气的书店老板
 * @date 2021/2/23
 */
public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int len = customers.length;
        for (int i = 0; i < len; ++i) {
            total += customers[i] * (1 - grumpy[i]);
        }
        int curTemp = 0;
        int maxTemp = 0;
        for (int i = 0; i < X; ++i) {
            curTemp += customers[i] * grumpy[i];
        }
        maxTemp = curTemp;
        for (int i = X; i < len; ++i) {
            if (grumpy[i] == 1) {
                curTemp += customers[i];
            }
            if (grumpy[i - X] == 1) {
                curTemp -= customers[i - X];
            }
            maxTemp = Math.max(maxTemp, curTemp);
        }
        return total + maxTemp;
    }
}
