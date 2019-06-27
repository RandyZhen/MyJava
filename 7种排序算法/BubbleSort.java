package zhen.sort;

/**
 * 冒泡排序（稳定）   O(N*2)
 * 冒泡算法的运作规律如下：
 * 　　①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 　　②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数（也就是第一波冒泡完成）。
 * 　　③、针对所有的元素重复以上的步骤，除了最后一个。
 * 　　④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) { //这里for循环表示总共需要比较多少轮
            //对当前无序区间array[0......length-i]进行排序
            // 因为每轮比较都会出现一个最大值放在最右边，所以每轮比较后的元素个数都会少一个，这也是为什么 j 的范围是逐渐减小的
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);
        }
        return array;
    }

    public static void display(int[] array) {    //遍历显示数组
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
    }

}