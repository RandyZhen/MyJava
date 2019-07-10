package zhen.swordoffer.Done;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 对应每个测试案例，输出两个数，小的先输出
 */
public class FindNumbersToSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 10;
        System.out.println(FindNumbersWithSum(arr, sum));
    }

    /**
     * 定义两个指针，一个头指针，一个尾指针，当两个指针的数字之和大于s时，尾指针前移，之和小于s时，头指针后移，等于s时，输出即可
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                result.add(array[i]);
                result.add(array[j]);
                i++;
                break;
            } else if (cur < sum) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
