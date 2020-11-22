import java.util.*;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * @author Yin
 * @date 2020/10/31
 */
public class RandomizedCollection {
    public List<Integer> nums;
    public Map<Integer, Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if (!map.containsKey(val)) {
            flag = true;
            map.put(val, new HashSet<>());
        }
        Set<Integer> set = map.get(val);
        nums.add(val);
        set.add(nums.size() - 1);
        map.put(val, set);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 获得val在列表中的索引
        Set<Integer> valIndexSet = map.get(val);
        int valIndex = valIndexSet.iterator().next();
        valIndexSet.remove(valIndex);
        if (valIndexSet.size() == 0) {
            map.remove(val);
        }

        // 最后一个元素的索引
        int lastNum = nums.remove(nums.size() - 1);
        if (valIndex < nums.size()) {
            nums.set(valIndex, lastNum);
            map.get(lastNum).remove(nums.size());
            map.get(lastNum).add(valIndex);
        }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }
}
