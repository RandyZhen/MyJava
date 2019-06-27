package zhen.swordoffer.Done;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 2, 1};
        System.out.println("方法1重复数字：" + findDuplicate(nums));
    }

    private static int findDuplicate(int[] nums) {
        /**方法1 利用hashmap中的key属性 没有修改数组 时间O(N) 空间O(N)*/
        HashMap<Integer, Integer> hs = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hs.containsKey(nums[i])) {
                hs.put(nums[i], nums[i]);
            } else {
                res = nums[i];
                break;
            }
        }
        /**方法2 先排序，然后遍历  修改数组 时间O(NlogN) 空间O(1)*/
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i) {
                if (nums[i] == nums[i++]) {
                    System.out.println("方法2重复数字：" + nums[i]);
                    break;
                }
            }
        }
        /**方法3 重拍数组：修改数组 时间O(N) 空间O(1)
         * 依次扫描数组，扫描到下标i的数字m时，比较这个数字是不是等于i：
         *              如果相等，接着扫描下一个数字
         *              如果不相等，把下标i的数字m和第m下标数字比较，如果相等，则找到一个重复的数字，如果不等，把第i个数字和第m个数字交换
         *              依次重复这个过程*/
        A:
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println("方法3重复数字：" + nums[i]);
                    break A;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        /**方法4  二分查找 统计区间数字的数目 没有修改数组 时间O(NlogN) 空间O(1)*/
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = ((end-start) >> 1)+start;
            int count = Count(nums, start, middle);
            if (start == end) {
                if (count > 1) {
                    System.out.println("方法4重复数字：" + start);
                    break;
                }
                else{
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }


        return res;

    }

    /**
     * 得到分布在区间[start,end]的nums[i]的个数
     */
    private static int Count(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) count++;
        }
        return count;
    }

}
/**
 * Returns <tt>true</tt> if this map contains a mapping for the
 * specified key.
 * <p>
 * 判断hashmap中是否包含key这个键
 * public boolean containsKey(Object key) {
 * return getNode(hash(key), key) != null;
 * }
 * <p>
 * /**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 * <p>
 * 把value赋值到hashmap中键key对应的值上
 * public V put(K key, V value) {
 * return putVal(hash(key), key, value, false, true);
 * }
 */