import java.util.HashMap;
import java.util.Map;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 数组的度
 * @date 2021/2/20
 * 子数组如果要度和原数组一样，那么原数组中最多的数一定都要包含在子数组中
 */
public class Solution697 {
    static class Helper {
        int start;
        int end;
        int count;
    }
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Helper> map = new HashMap<>();
        int maxValue = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Helper helper = new Helper();
            if (!map.containsKey(num)) {
                helper.start = i;
                helper.end = i;
                helper.count = 1;
            } else {
                helper = map.get(num);
                helper.end = i;
                helper.count += 1;
            }
            maxValue = Math.max(maxValue, helper.count);
            map.put(num, helper);
        }
        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            Helper value = map.get(key);
            if (value.count == maxValue) {
                res = Math.min(res, value.end - value.start + 1);
            }
        }
        return res;
    }
}
