package zhen.swordoffer.Done;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class ShuzuXuanzhuan {
    public static void main(String[] args) {
        int[] arrays = {4, 2, 8, 9, 5, 7, 6, 2, 3};
        System.out.println(minNumberInRotateArray(arrays));
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int res = 0;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                res = end;
                break;
            }
            //特殊情况，如果arr[end]==arr[start]==arr[res],只能顺序查找   01111   10111   11101
            if (array[start] == array[res] && array[end] == array[res]) return MininOrder(array, start, end);

            res = (start + end) / 2;
            if (array[start] <= array[res]) start = res;
            else if (array[end] >= array[res]) end = res;
        }
        return array[res];
    }

    private static int MininOrder(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > arr[i]) result = arr[i];
        }
        return result;
    }
}
/**
 * 利用数组的递增和旋转特性，变相的二分查找，注意一些特殊情况的讨论
 */