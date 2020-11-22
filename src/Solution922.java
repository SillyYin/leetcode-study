import java.util.*;

/**
 * @author Yin
 * @date 2020/11/12
 */
public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            int num = A[i];
            if (num % 2 == 0 && i % 2 != 0) {
                map1.put(i, num);
            }
            if (num % 2 != 0 && i % 2 == 0) {
                map2.put(i, num);
            }
        }

        List<Integer> keyList1 = new ArrayList<>(map1.keySet());
        List<Integer> keyList2 = new ArrayList<>(map2.keySet());
        for (int i = 0; i < keyList1.size(); ++i) {
            A[keyList1.get(i)] = map2.get(keyList2.get(i));
            A[keyList2.get(i)] = map1.get(keyList1.get(i));
        }
        return A;
    }

}
