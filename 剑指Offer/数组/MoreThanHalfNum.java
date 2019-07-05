package zhen.swordoffer.Done;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 2, 2, 1, 2, 1, 1, 1, 2};
        MoreThanHalfNum m = new MoreThanHalfNum();
        System.out.println(m.MoreThanHalfNum_Solution(arr));
    }
/** 一种解法:
 * 采用用户“分形叶”思路（注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。
 * 如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把最后剩下的一个数字或者两个回到原来数组中，将数组遍历一遍统计一下数字出现次数进行最终判断。
 * 具体步骤：遍历数组，保存数组中的数字和次数，如果下一个数字和之前保存的数字相同，则次数加1，如若不同，则次数减1，若次数为0，则保存下一个数字，并把次数设为1，
 * 要找的数字就是最后一次把次数设为1的数字。
 * */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            result = 0;
        }
        return result;

    }
}
/**
 * 另一种解法，排序后,如果存在此数字，则必在数组中间
 * int count=0;
 * Arrays.sort(array);
 * for(int i=0;i<array.length;i++){
 * if(array[i]==array[array.length/2]){
 * count++;
 * }
 * }
 * if(count>array.length/2){
 * return array[array.length/2];
 * }
 * return 0;
 */