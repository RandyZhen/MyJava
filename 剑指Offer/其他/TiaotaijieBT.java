package zhen.swordoffer.Done;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class TiaotaijieBT {
    public static int JumpFloorII(int target) {
        int a = target - 1;
        return (int) (Math.pow(2, a));
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(JumpFloorII(n));
    }
}
/**数学归纳法：f(n)=2^(n-1)*/