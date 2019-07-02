package zhen.example;

import java.util.*;

/**
 * 输入n,按顺序输出从1到最大的n位数，例如输入3，输出1、2、3....999。
 * 当n很大时，整型int和长整型long long会溢出，考虑大数问题
 */
public class Print1toN {
    public static void main(String[] args) {
        Print1toN test = new Print1toN();
        test.printToMax(3);
        //printToMax2(3);
    }

    /**
     * 字符串上模拟加法
     */
    public void printToMax(int n) {
        if (n < 0)
            return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increment(number)) {//没到达最高位溢出
            printNumber(number);
        }
        return;
    }

    /**
     * 在表示数字的字符串num上增加1，用O(1)时间判断是否达到最大的n位数：当我们发现加1时，第一个字符产生了进位，则已经到达最大的n位数：isOverflow = true
     */
    public boolean increment(char[] num) {
        boolean isOverflow = false;
        int size = num.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {//在字符串上模拟加法
            int temp = num[i] - '0' + carry;
            if (i == size - 1)
                temp++;
            if (temp >= 10) {
                if (i == 0) //最高位（字符的第一位）溢出：999--->1000,已经到达最大的n位数
                    isOverflow = true;
                else {
                    temp -= 10;
                    carry = 1;
                    num[i] = (char) ('0' + temp);
                }
            } else {
                num[i] = (char) ('0' + temp);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 从第1个非0字符后开始打印
     */
    public static void printNumber(char[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == '0') //i < size在前，否则越界
            i++;
        if (i == size)//不打印全0
            return;
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);
    }


    /**
     * 第二种思路：n位的所有十进制数就是n个从0到9的全排列：递归
     * 字符每一位进行全排列
     */
    public static void printToMax2(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number, n, 0);
    }

    public static void printOrder(char[] number, int n, int loc) {
        if (loc == n) return;
        for (int i = 0; i <= 9; i++) {
            number[loc] = (char) ('0' + i);
            if (loc == n - 1) {
                printNumber(number);
            }
            printOrder(number, n, loc + 1);
        }
    }
}
