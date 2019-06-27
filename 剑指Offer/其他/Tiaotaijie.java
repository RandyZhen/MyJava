package zhen.swordoffer.Done;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Tiaotaijie {
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= target; i++) {
            f0 = f1 + f2;
            f1 = f2;
            f2 = f0;

        }
        return f0;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(JumpFloor(n));
    }
}
/**f(n)
 * 第一次跳1级 剩下n-1级台阶f(n-1)
 * 第一次跳2级 剩下n-2级台阶f(n-2)
 * f(n)=f(n-1)+f(n-2)
 * */