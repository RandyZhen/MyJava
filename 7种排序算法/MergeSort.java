package zhen.sort;

import java.util.Arrays;

/**
 * 归并排序（稳定） O(NlogN)  空间复杂度 O(N) 需要一个临时数组进行归并
 * 利用递归和分治将数据划分为越来越小的半子表，再对半子表排序，
 * 最后再用递归方法将排好序的半子表合并称为有序序列
 * 原理如下：给定一组数据，首先将每两个相邻的长度为1的子序列进行归并，
 * 得到n/2（向上去整）个长度为2或1的有序子序列，再将其两两归并，
 * 反复执行此过程
 */
public class MergeSort {
    //递归使用归并排序，对arr[l...right]的范围进行排序（前闭区间，后闭区间）
    private static void mergeSort(int[] arr, int left, int right) {
        //对于递归，要处理递归结束的判断，这里就是left>=right。
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);//左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right); //将左右两部分，利用临时数组进行归并
        }
    }

    //将arr[l...mid]和arr[mid+1...right]两部分进行归并
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; //临时辅助数组,避免递归中频繁开辟空间
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){//依次比较左右两边的最小元素(即左右两边的第一个元素)，将比较后的最小元素填充进temp中
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//此时j>right:右边元素已经全部复制到temp，将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//此时i>mid:左边元素已经全部复制到temp，将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        System.out.println("归并排序前：" + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序后：" + Arrays.toString(arr));
    }

}
