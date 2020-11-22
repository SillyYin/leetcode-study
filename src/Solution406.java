import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yin
 * @date 2020/11/18
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int peopleSize = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        int[] flags = new int[peopleSize];
        int[][] res = new int[peopleSize][2];
        for (int[] person : people) {
            int h = person[0];
            int k = person[1];
            for (int i = 0; i < peopleSize; ++i) {
                if (flags[i] == 0) {
                    k--;
                }
                if (k < 0) {
                    flags[i] = 1;
                    res[i] = person;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution406 solution406 = new Solution406();
        solution406.reconstructQueue(a);
    }
}
