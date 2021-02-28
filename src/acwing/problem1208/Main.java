package acwing.problem1208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 翻硬币
 * @date 2021/2/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] value = in.nextLine().toCharArray();
        char[] target = in.nextLine().toCharArray();
        int len = value.length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            if (!queue.isEmpty() && i > queue.peek() + 1) {
                queue.poll();
            }
            // 队列长度表示这个位置被翻转的次数，需要翻转才要进入循环
            if ((queue.size() % 2 == 0 && value[i] != target[i]) || (queue.size() % 2 != 0 && value[i] == target[i])) {
                queue.add(i);
                res++;
            }
        }
        System.out.println(res);
    }
}
