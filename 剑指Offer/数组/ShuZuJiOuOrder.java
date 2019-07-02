package zhen.swordoffer.Done;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Stack;

public class ShuZuJiOuOrder {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reOrderArray(array);// reOrderArray1(array);
        for (int i : array) {
            System.out.print("[" + i + "]");
        }
    }

    /**
     * 方法1：直接遍历数组
     */
    public static void reOrderArray(int[] array) {
        int[] arr = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                stack.push(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                stack.push(array[i]);
            }
        }
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = stack.pop();
            array[j] = arr[i];
        }
    }

    /**
     * 方法2：两个指针分别指向头尾，向中间移动：如果第一个指针指向偶数，第二个指针指向奇数，交换值，继续移动，直到指针相遇
     */
    private static void reOrderArray1(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (begin < end && array[begin] % 2 == 1) {
                begin++;
            }
            while (begin < end && array[end] % 2 == 0) {
                end--;
            }
            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }
    /***/
}
