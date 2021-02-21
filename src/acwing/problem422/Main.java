package acwing.problem422;

import java.util.*;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 校门外的树
 * @date 2021/2/21
 */
public class Main {
    static class Dist {
        int left;
        int righ;

        public Dist(int left, int righ) {
            this.left = left;
            this.righ = righ;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        int l = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        List<Dist> distList = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String line = in.nextLine();
            int start = Integer.parseInt(line.split(" ")[0]);
            int end = Integer.parseInt(line.split(" ")[1]);
            distList.add(new Dist(start, end));
        }
        distList.sort(Comparator.comparingInt(o -> o.left));
        // 起始区间
        int start = 0;
        int end = -1;
        int res = 0;
        for (Dist dist : distList) {
            if (dist.left > end) {
                // 将结果保存
                res += end - start + 1;
                start = dist.left;
                end = dist.righ;
            } else {
                end = Math.max(end, dist.righ);
            }
        }
        // 最后一次的结果没有保存
        res += end - start + 1;
        System.out.println(l + 1 - res);
    }
}
