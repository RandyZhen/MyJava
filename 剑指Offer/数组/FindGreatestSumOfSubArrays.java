package zhen.swordoffer;

/**
 * 动态规划问题
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        FindGreatestSumOfSubArrays find = new FindGreatestSumOfSubArrays();
        System.out.println(find.FindGreatestSumOfSubArray2(arr));

    }

    /**
     * 思路一：观察分析数组规律发现：逐个累加数组中的每个数字，一旦累加和小于0，就把前面数字全部舍弃掉，从后一个开始累加，保存更新最大的累加值
     */
    public int FindGreatestSumOfSubArray2(int[] arr) {
        if (arr.length==0 || arr==null) {
            return 0;
        }
        int res = 0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (res < 0) res = arr[i];
            else res += arr[i];
            if(max<res) max=res;
        }
        return max;
    }

    /**
     * 动态规划思路
     * 根据数组中最后一个元素与最大子数组的关系分为二种情况：
     * 情况1.最大子数组包含最后一个元素（分为两种情况：1.最后一个元素单独构成最大子数组2.最后一个元素是最大子数组的一部分）
     * 情况2.最大子数组不包含最后一个元素，那么求最大子数组转换为求去除最后一个元素的数组的最大子数组
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) return 0;
        int start = 0, end = 0;
        int sum = array[0];//包含最后一个元素的最大子数组和
        int maxSum = array[0];//最大子数组和
        for (int i = 1; i < array.length; i++) {
            if (sum < 0) start = i;
            sum = Math.max(sum + array[i], array[i]);//对应情况1
            if (sum > maxSum) end = i;
            maxSum = Math.max(sum, maxSum);//对应情况1和2
        }
        System.out.println(start + "-" + end);
        return maxSum;
    }
}
/**
 * 如何确定最大子数组的位置呢？
 * sum<0时，子数组从arr[i]重新开始，所以start=i;
 * sum>maxSum时，元素一直加入子数组，所以end=i;
 */