package zhen.swordoffer.Done;

import java.util.Arrays;
/**
 * 输入n个整数，找出其中最小的K个数。
 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] in = {10, 2, 4, 5, 1, 7, 3};
        int k = 4;
        GetLeastNumbers get = new GetLeastNumbers();
        System.out.println(get.GetLeastNumbers_Solution(in, k));

    }

    /**
     * 方法1：排序后，取前k位，时间复杂度O(NlogN)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input==null || k<=0 || k > input.length) return arrayList;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}
/**
 * 方法2：采用partition方法  时间复杂度O(N) 需要修改数组
 * 基于数组第k个数字来调整，比第k个数字小的放在第k个数的左边，大的位于第k个数右边，
 * 则位于数组中左边的k个数字就是最小的k个数字（不一定排序）
 *
 * public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
 *         ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
 *         while(input==null || k<=0 || k>input.length)
 *             return leastNumbers;
 *         int start=0;
 *         int end=input.length-1;
 *         int index=partition(input,start,end);
 *         while(index!=k-1){
 *             if(index<k-1){
 *                 start=index+1;
 *                 index=partition(input,start,end);
 *             }else{
 *                 end=index-1;
 *                 index=partition(input,start,end);
 *             }
 *         }
 *         for(int i=0;i<k;i++){
 *             leastNumbers.add(input[i]);
 *         }
 *         return leastNumbers;
 *     }
 *
 *     private int partition(int[] arr, int start,int end){
 *         int pivotKey=arr[start];
 *         while(start<end){
 *             while(start<end && arr[end]>=pivotKey)
 *                 end--;
 *             swap(arr,start,end);
 *             while(start<end && arr[start]<=pivotKey)
 *                 start++;
 *             swap(arr,start,end);
 *         }
 *         return start;
 *     }
 *
 *     private void swap(int[] arr, int i,int j){
 *         int temp=arr[i];
 *         arr[i]=arr[j];
 *         arr[j]=temp;
 *     }
 */

/**方法3：用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。时间复杂度O(NlogK)
 *
 * import java.util.ArrayList;
 * import java.util.PriorityQueue;
 * import java.util.Comparator;
 * public class Solution {
 *    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
 *        ArrayList<Integer> result = new ArrayList<Integer>();
 *        int length = input.length;
 *        if(k > length || k == 0){
 *            return result;
 *        }
 *         PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
 *
 *             @Override
 *             public int compare(Integer o1, Integer o2) {
 *                 return o2.compareTo(o1);//降序,(x < y) ? -1 : ((x == y) ? 0 : 1);
 *             }
 *         });
 *         for (int i = 0; i < length; i++) {
 *             if (maxHeap.size() != k) {
 *                 maxHeap.offer(input[i]);
 *             } else if (maxHeap.peek() > input[i]) {
 *                 Integer temp = maxHeap.poll();
 *                 temp = null;
 *                 maxHeap.offer(input[i]);
 *             }
 *         }
 *         for (Integer integer : maxHeap) {
 *             result.add(integer);
 *         }
 *         return result;
 *     }
 * }*/