/**
 * @author Yin
 * @date 2021/2/17
 */
public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if (rows * columns != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int[] shapeNumbers = new int[rows * columns];
        int j = 0;
        for (int[] num : nums) {
            for (int i : num) {
                shapeNumbers[j++] = i;
            }
        }
        j = 0;
        for (int i = 0; i < r; ++i) {
            for (int k = 0; k < c; ++k) {
                res[i][k] =  shapeNumbers[j++];
            }
        }
        return res;
    }
}
