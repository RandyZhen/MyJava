package zhen.swordoffer.Done;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
*/
/**先用java集合PriorityQueue来设置一个小顶堆和大顶堆
 主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
 小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
 ⭐保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
 ⭐保证数据平均分配到两个堆中，两个堆中的数据的数目之差不能超过1，所以
 ⭐当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
 ⭐当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
 ⭐取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点
 */
public class MidNumOfDataStream {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();//小顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {//大顶堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }//降序
    });
    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public void Insert(Integer num) {
        if (count % 2 == 0) {//个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {//个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            maxHeap.add(minHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) return new Double((maxHeap.peek() + minHeap.peek())) / 2;//当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        else return new Double(minHeap.peek()); //当前为奇数个，则直接从小顶堆中取元素即可
    }
}
