/**
 * @author Yin
 * @date 2020/11/18
 */
public class Solution845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1:0;
        }
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1:0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] != 0 && right[i] != 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
