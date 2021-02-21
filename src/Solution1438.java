import java.util.Map;
import java.util.TreeMap;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 绝对差不超过限制的最长连续子数组
 * @date 2021/2/21
 */
public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        // 可以保证key的大小顺序
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        while (right < len) {
            int item = nums[right];
            map.put(item, map.getOrDefault(item, 0) + 1);
            // treemap的特有方法
            while (left <= right && map.lastKey() - map.firstKey() > limit) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
