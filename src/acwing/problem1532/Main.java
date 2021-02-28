package acwing.problem1532;

import java.util.*;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 找硬币
 * @date 2021/2/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int coin = in.nextInt();
            int remain = m - coin;
            if (map.containsKey(coin)) {
                if (remain < coin) {
                    res.add(new int[]{remain, coin});
                } else {
                    res.add(new int[]{coin, remain});
                }
            }
            map.put(remain, coin);
        }
        if (res.isEmpty()) {
            System.out.println("No Solution");
            return;
        }
        res.sort(Comparator.comparingInt(o -> o[0]));
        System.out.println(res.get(0)[0] + " " + res.get(0)[1]);
    }
}
