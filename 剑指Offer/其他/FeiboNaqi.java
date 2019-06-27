package zhen.swordoffer.Done;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FeiboNaqi {
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        int f1 = 0;
        int f2 = 1;

        for (int i = 2; i <= n; i++) {
            res = f2 + f1;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(Fibonacci(n));
    }
}
/**从下往上计算 时间O(N)*/