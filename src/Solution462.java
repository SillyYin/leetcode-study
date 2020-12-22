import java.util.Arrays;

/**
 * 最终变成的数一定是排序数组中的中位数
 * @author Yin
 * @date 2020/12/22
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        for (int num : nums) {
            res += Math.abs(num - target);
        }
        return res;
    }
}
