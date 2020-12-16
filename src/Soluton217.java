import java.util.HashSet;
import java.util.Set;

/**
 * @author Yin
 * @date 2020/12/13
 */
public class Soluton217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
        //return IntStream.of(nums).distinct().count() != nums.length;
    }
}
