/**
 * @author yinrongjie
 * @version 1.0
 * @description 最大连续1的个数 III
 * @date 2021/2/19
 */
public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int len = A.length;
        int res = 0;
        int zeros = 0;
        while (right < len) {
            if (A[right] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (A[left++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
