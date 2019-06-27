package zhen.sort;

/**
 * 直接插入排序（稳定） O(N*2)
 * 基本思想是每一步将一个待排序的记录，
 * 插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class InsertSort {
    /*        复制的次数大致等于比较的次数，但是一次复制与一次交换的时间耗时不同，所以相对于随机数据，插入排序比冒泡快一倍，比选择排序略快。
        如果要进行逆序排列，那么每次比较和移动都会进行，这时候并不会比冒泡排序快。*/
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {//从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
            int tmp = array[i];//记录要插入的数据
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {//从已经排序的序列最右边的开始比较，找到比其小的数
                array[j] = array[j - 1];//向后挪动
                j--;
            }
            array[j] = tmp;//存在比其小的数，插入
            display(array);
        }
        return array;
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {38, 65, 97, 76, 13, 27, 49};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }

}
