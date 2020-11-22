import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yin
 * @date 2020/11/14
 */
public class Solution1122 {
    public static final Map<Integer, Integer> map = new HashMap<>();
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; ++i) {
            map.put(arr2[i], i);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : arr1) {
            if (map.containsKey(num)) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        list1.sort(Comparator.comparingInt(map::get));
        Collections.sort(list2);
        list1.addAll(list2);
        int[] res = new int[list1.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list1.get(i);
        }
        return res;
    }
}
