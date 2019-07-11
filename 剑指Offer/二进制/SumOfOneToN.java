package zhen.swordoffer.Done;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class SumOfOneToN {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(Sum_Solution(n));
    }

    /**
     * 1.需利用逻辑与&&的短路特性实现递归终止。
     * 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     */

    public static int Sum_Solution(int n) {
        int res = n;
        boolean ans = res > 0 && (res += Sum_Solution(n - 1)) > 0;
        return res;
    }
}
/**
 * n = (int) (Math.pow(n, 2)+n)>>1;
 * return n;
 */
