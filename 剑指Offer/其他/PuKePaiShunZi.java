package zhen.swordoffer.Done;

import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class PuKePaiShunZi {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 4, 2};
        System.out.println(isContinuous(numbers));
    }

    /**
     * 1）max-min<5;
     * 2）除0外无重复的数字
     * 3）数组长度为5
     */
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) continue;
            if (d[numbers[i]] > 1) return false;
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
        }
        if (max - min < 5) return true;
        return false;
    }
}
/**
 * 另一种思路：
 * 1、排序
 * 2、计算所有相邻数字间隔总数
 * 3、计算0的个数
 * 4、如果2>3，就是顺子
 * 5、如果出现对子，则不是顺子
 * <p>
 * int numOfZero=0;
 * int inteval=0;
 * for(int i=0;i<numbers.length-1;i++){
 * if(numbers[i]==0){
 * numOfZero++;
 * continue;
 * }
 * if(numbers[i]==numbers[i+1]) return false;
 * inteval+=numbers[i+1]-numbers[i]-1;
 * }
 * if(numOfZero>=inteval) return true;
 * return false;
 */
