import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 每次让n-1个数加1，相当于让一个数减1，最后的操作次数就是让所有的数都减到最小值的次数
 * @author Yin
 * @date 2020/12/22
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
