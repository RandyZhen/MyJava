package zhen.swordoffer.Done;
/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;

public class FindContinuousSequenceToSum {
    public static void main(String[] args) {
        int sum = 15;
        System.out.println(FindContinuousSequence(sum));
    }
    /**
     * 我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，而这个序列的中间值代表了平均值的大小。
     * 假设序列长度为n，那么这个序列的中间值可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。
     **/
    /**
     * 满足条件的n分两种情况：
     * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
     * n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
     * 由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
     * 根据等差数列的求和公式：S = (1 + n) * n / 2，得到n<=sqrt(2 * sum)
     * 最后举一个例子，假设输入sum = 100，我们只需遍历n = 14~2的情况（按题意应从大到小遍历），
     * n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 3) return lists;
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && (sum % n == 0) || (n & 1) != 1 && (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = sum / n - (n - 1) / 2, j = 0; j < n; j++, i++) {
                    list.add(i);
                }
                lists.add(list);
            }
        }
        return lists;
    }
}

/**
 * 另一种思路：
 * 双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
 * public class Solution {
 *      public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
 *          ArrayList<ArrayList<Integer> > result = new ArrayList<>();
 *                  int plow = 1,phigh = 2;//两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
 *                  while(phigh > plow){
 *                 int cur = (phigh + plow) * (phigh - plow + 1) / 2;//由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
 *                  if(cur == sum){//相等，那么就将窗口范围的所有数添加进结果集
 *                      ArrayList<Integer> list = new ArrayList<>();
 *                      for(int i=plow;i<=phigh;i++){
 *                           list.add(i);
 *                              }
 *                  result.add(list);
 *                  plow++;
 *                  }else if(cur < sum){//如果当前窗口内的值之和小于sum，那么右边窗口右移一下
 *                  phigh++;
 *                  }else{ //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
 *                plow++;
 *                   }
 *          }
 *              return result;
 * }
 * }
 */