package acwing.problem1346;

import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 回文平方
 * @date 2021/2/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        for (int i = 1; i < 300; ++i) {
            String res = base(i * i, b);
            if (check(res)) {
                System.out.println(base(i, b) + " " + res);
            }
        }
    }

    private static boolean check(String res) {
        int right = res.length() - 1;
        int left = 0;
        char[] resChars = res.toCharArray();
        while (left < right) {
            if (resChars[left++] != resChars[right--]) {
                return false;
            }
        }
        return true;
    }

    private static char get(int num) {
        if (num <= 9) {
            return Integer.toString(num).charAt(0);
        }
        return (char) ((char)(num - 10) + 'A');
    }

    /**
     * 得到10进制数n的b进制数
     * @param n
     * @param b
     * @return
     */
    private static String base(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(get(n % b));
            n /= b;
        }
        return sb.reverse().toString();
    }
}
