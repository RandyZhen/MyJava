package zhen.sort;

import java.util.Arrays;

/**
 * 希尔排序(不稳定）O(NlogN)
 * 希尔排序（shell sort）这个排序方法又称为缩小增量排序
 * 该方法的基本思想是：设待排序元素序列有n个元素，首先取一个整数increment（小于n）作为间隔将全部元素分为increment个子序列，
 * 所有距离为increment的元素放在同一个子序列中，在每一个子序列中分别实行直接插入排序。
 * 然后缩小间隔increment，重复上述子序列划分和排序工作。直到最后取increment=1，将所有元素放在同一个子序列中排序为止。
 */
public class ShellSort {
    //希尔排序 针对有序序列在插入时采用交换法
    public static void sort(int[] arr) {        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {            //从第gap个元素，逐个对其所在组进行直接插入排序操作
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);                    //插入排序采用交换法
                    j -= gap;
                }
            }
        }
    }
/*
    //希尔排序 针对有序序列在插入时采用移动法。
    public static void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }*/

//交换数组元素

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 9, 8, 4, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
/*        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));*/
    }

}
