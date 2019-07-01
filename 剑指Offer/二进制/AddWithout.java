package zhen.swordoffer.Done;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddWithout {
    public static void main(String[] args) {
        int n = 20;
        int m = 4;
        System.out.println(Add(n, m));

    }

    public static int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1= sum;
        }
        return num1;
    }
}
/**记住结论！！！！！
 * 两个数异或：相当于每一位相加，而不考虑进位；(二进制每位相加就相当于各位做异或操作)
 * 两个数相与，并左移一位：相当于求得进位；
 * 将上述两步的结果相加
 */
