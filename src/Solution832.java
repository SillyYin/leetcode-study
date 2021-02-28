/**
 * @author yinrongjie
 * @version 1.0
 * @description 翻转图像
 * @date 2021/2/24
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; ++i) {
            int j = 0;
            int k = m - 1;
            while (j <= k) {
                if (j == k) {
                    A[i][j] = 1 - A[i][j];
                    break;
                }
                A[i][j] = 1 - A[i][j];
                A[i][k] = 1 - A[i][k];
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
                j++;
                k--;
            }
        }
        return A;
    }
}
