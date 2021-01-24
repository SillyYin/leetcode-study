/**
 * 将第一个点移动到原点的位置，其他的点跟着一起移动相同的坐标，能够用第二个点确定一条直线，判断其他点是否满足直线方程
 * @author Yin
 * @date 2021/1/17
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
