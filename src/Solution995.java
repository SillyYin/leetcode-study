import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yinrongjie
 * @version 1.0
 * @description K 连续位的最小翻转次数
 * @date 2021/2/18
 */
public class Solution995 {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.length; ++i) {
            // 队列中的元素个数就是遍历到第i位的时候第i位要翻转的次数
            if (!queue.isEmpty() && i > queue.peek() + K - 1) {
                queue.poll();
            }
            // 当第i位是0的时候，如果已经翻转了偶数次（队列的长度是偶数），则需要再次进行翻转
            // 当第i位是1的时候，如果已经翻转了奇数次（队列的长度是奇数），则需要再次进行翻转
            if (A[i] == queue.size() % 2) {
                if (i + K > A.length) {
                    return -1;
                }
                queue.add(i);
                res++;
            }
        }
        return res;
    }
}
