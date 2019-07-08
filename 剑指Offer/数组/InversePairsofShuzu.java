package zhen.swordoffer.Done;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1: 输入1,2,3,4,5,6,7,0  输出7
 */
public class InversePairsofShuzu {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        InversePairsofShuzu i = new InversePairsofShuzu();
        System.out.println(i.InversePairs(arr));
    }

    /**
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += j-mid
     */
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    public int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) return 0;
        int mid = (high + low) >> 1;
        int leftcount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightcount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];

                if (count >= 1000000007)
                {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }

        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftcount + rightcount + count) % 1000000007;
    }
}
