package zhen.swordoffer.Done;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(maxInWindows(num, size));
    }

    /**
     * 用双端队列实现窗口最大值的更新，双端队列qmax来存放num的下标
     **/
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> qmax = new LinkedList<>();//双端队列,用来记录每个窗口的最大值下标
        if (num.length == 0 || size > num.length) return result;
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - size) {//判断队首元素是否过期
                qmax.pollFirst();
            }
            if (i >= size - 1) {//从遍历到第一个窗口的最后一个位置时开始加
                result.add(num[qmax.peekFirst()]);
            }
        }

        return result;
    }

}
/**
 * 暴力破解法
 * public ArrayList<Integer> maxInWindows(int [] num, int size)
 * {
 * ArrayList<Integer> result=new ArrayList<Integer>();
 * if(num.length==0||size>num.length) return result;
 * for(int i=0;i<num.length-size+1;i++){
 * int maxNum=num[i];
 * for(int j=i+1;j<i+size;j++){
 * if(num[j]>maxNum) maxNum=num[j];
 * }
 * result.add(maxNum);
 * }
 * return result;
 * }
 */