import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yin
 * @date 2020/12/6
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i < numRows; ++i) {
            List<Integer> last = res.get(i - 1);
            int lastLen = last.size();
            int count = i + 1;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < count; ++j) {
                if (j - 1 < 0 || j >= lastLen) {
                    temp.add(1);
                } else {
                    temp.add(last.get(j) + last.get(j - 1));
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
