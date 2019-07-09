package zhen.swordoffer.Done;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfShuZu {
    public static void main(String[] args) {
        int[] array = {1, 1, 3, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9};
        int k = 6;
        GetNumberOfShuZu get = new GetNumberOfShuZu();
        System.out.println(get.GetNumberOfK(array, k));
    }

    /**
     * 思路1：直接遍历查找，O(N)
     * 思路2：利用排序特性二分查找O(logN)，查找第一个k和最后一个k
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        if (first == -1 || last == -1) {
            return 0;
        } else {
            return last - first + 1;
        }

    }

    /**
     * 找到数组中的第一个k，返回第一个k在数组中的下标
     */
    public int getFirstK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (k < array[mid]) {
                end = mid - 1;
            } else if (k > array[mid]) {
                start = mid + 1;
            } else {
                if ((array[mid - 1] != k && mid > 0) || mid == 0)
                    return mid;
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 找到数组中最后一个k，返回最后一个k在数组中的下标
     */
    public int getLastK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (k < array[mid]) {
                end = mid - 1;
            } else if (k > array[mid]) {
                start = mid + 1;
            } else {
                if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1)
                    return mid;
                else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
