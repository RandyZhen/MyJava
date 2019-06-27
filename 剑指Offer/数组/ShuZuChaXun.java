package zhen.swordoffer.Done;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class ShuZuChaXun {
    public static boolean Find(int target, int[][] arrays) {
        int i = arrays.length - 1;
        int j = 0;
        while (i >= 0 && j < arrays[0].length) {
            if (target < arrays[i][j])
                i--;
            else if (target > arrays[i][j])
                j++;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 7;
        int[][] arrays = {{1, 2}, {2, 4}, {4, 7}};
        Find(target, arrays);
        System.out.println(Find(target, arrays));
    }
}
