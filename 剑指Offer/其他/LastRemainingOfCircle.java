package zhen.swordoffer.Done;
/**
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */

import java.util.LinkedList;

public class LastRemainingOfCircle {
    public static void main(String[] args) {
        int n = 6;
        int m = 3;
        System.out.println(LastRemaining_Solution(n, m));
    }

    /**
     * 约瑟夫环问题：0,1,2....n-1,这n个数字排成一个圆圈，从0开始，每次从这个圆圈中删除第m个数字，求出最后剩余的一个数字
     * 思路1：用环形链表模拟圆圈
     * 思路2：找到分析每次被删除的数字的规律直接计算得出最后结果
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();//来实现环形链表的功能,每次减去一人，所以每次只加m-1。
            list.remove(index);
        }
        return list.get(0);
    }
}
/**
 * 另一种思路：用数组来模拟环
 * if (n < 1 || m < 1) return -1;
 * int[] array = new int[n];
 * int i = -1;
 * int step = 0;
 * int count = n;
 * while (count > 0) {    //所有元素(喊过m-1)被删除，跳出循环
 * i++;
 * if (i >= n) i = 0;  //指向上一个被删除对象的下一个元素。
 * if (array[i] == -1) { //-1说明这个人是喊过m-1(被删除)的人,直接跳过
 * continue;
 * }
 * step++;
 * if (step == m) {//找到要喊m-1的人,标记为-1(相当于删除),然后开始从下一个人开始计数
 * step = 0;
 * count--;
 * array[i] = -1;
 * <p>
 * }
 * }
 * return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
 */
