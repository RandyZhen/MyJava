package zhen.sort;

/**
 * 快速排序（不稳定）最好O(NlogN)  最差O(N*2)  空间O(logN)需要一个栈空间实现递归
 * 采用的是分治法的思想，首先把一个数值序列划分为两个子序列，然后对两个子序列再进行分治，最终得到有序的序列。
 * 快速排序的流程：
 * 1) 从数值队列中选择一个基准值；
 * 2）将队列中的其他元素与基准值元素比较，小元素放左边，大元素放右边（递增序列），至此以基准值为中心划分为两部分，左边序列比基准值小，右边序列比基准值大；
 * 3）递归基准值左右两边的序列
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        temp = arr[low];              //temp就是基准位
        while (i < j) {          //i==j时跳出循环，第一次递归结束，此时基准在中间，左边的数都小于基准，右边的数都大于基准
            while (arr[j] >= temp && i < j) {//先看右边，依次往左递减，直到找到小于基准的第一个数
                j--;
            }
            while (arr[i] <= temp && i < j) {//再看左边，依次往右递增，直到找到大于基准的第一个数
                i++;
            }
            if (i < j) {            //把右边小于基准的第一个数和 左边大于基准的第一个数 进行交换
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 32, 3, 1, 8, 9, 19, 17};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/**
 * 快速排序（剪枝法）可以解决：
 * 1.找出数组中第k个最小的数
 * 2.找出数组中k个最小的数
 */




