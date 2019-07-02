package zhen.swordoffer.Done;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class DoubleDeIntCifang {
    public static void main(String[] args) {
        double base = 0.2;
        int exponent = -2;
        System.out.println(Power(base, exponent));

    }

    /**
     * 快速幂
     * * 写出指数的二进制表达，例如13表达为二进制1101。
     *  * 举例:10^1101 = 10^0001*10^0100*10^1000。
     *  * 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public static double Power(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (base - 0.0 == 0.00001 || base - 0.0 == -0.00001) {//double类型数字不能用==判断是否相等
            if (exponent < 0) {
                throw new RuntimeException("除0异常");
            } else {
                return 0.0;
            }
        }
        int e = exponent > 0 ? exponent : -exponent;
        double res = 1;
        while (e != 0) {
            res = (e & 1) == 1 ? res * base : res;
            base *= base;//翻倍
            e = e >> 1;
        }
        return exponent > 0 ? res : 1 / res;

    }
}
/**
 * 考虑到指数为0和负数的情况啊
 */