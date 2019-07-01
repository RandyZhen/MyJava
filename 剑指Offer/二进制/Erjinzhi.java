package zhen.swordoffer.Done;

/**位运算，整数右移一位相当于整数除以2，效率更高。
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Erjinzhi {
    public static int NumberOf1(int n) {
        String result = Integer.toBinaryString(n);
        char[] ch = result.toCharArray();
        int j = 0;
        for (char i : ch) {
            if (i == '1') {
                j++;
            }
        }
        return j;

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(NumberOf1(n));
        System.out.println(numberof1(n));
        System.out.println(numbersof1(n));
        System.out.println(numberbestof1(n));
    }

    /**
     * 先判断整数的最右边是不是1：通过与1相与
     * 把整数右移一位，接着判断最右边
     * 存在问题：负数不能用，因为负数右移的话，在高位补1，
     * 一直右移，会变成FFFFFFFFFF，死循环
     */
    private static int numberof1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 改进方法：把1逐渐左移，和整数n相与
     */
    private static int numbersof1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 最好的解法：一个整数减1与原整数相与，就是相当于整数的最右边的1变成0
     */
    private static int numberbestof1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
/**相关题目
 * 1.判断一个整数是不是2的整数次方？
 *     如果一个整数是2的整数次方，这个数的二进制中只有一位是1，其余全为0
 *     if((n-1)&n==0)既满足条件
 * 2.输入两个整数m和n，需要改变m二进制多少位才能得到n？
 *      m和n异或m^n，统计1的个数*/