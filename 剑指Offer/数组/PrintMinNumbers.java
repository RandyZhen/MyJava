package zhen.swordoffer.Done;
/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 32, 321, 1321};
        PrintMinNumbers p = new PrintMinNumbers();
        System.out.println(p.PrintMinNumber(arr));

    }
/**思路：两个数m、n，如果mn<nm 则定义m是小于n的：即m是在n前面的；如果mn>nm 则定义m是大于n的：即m是在n后面的
 * 把数字替换为字符串，按字符串规则比较大小即可*/
    public String PrintMinNumber(int[] numbers) {
        String result = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return "";
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
                    public int compare(Integer str1, Integer str2) {
                        String s1 = str1 + "" + str2;
                        String s2 = str2 + "" + str1;
                        return s1.compareTo(s2);//升序

                    }
                }
        );
        for (int i : arrayList) {
            result += i;
        }
        return result;
    }
}
/**

 * 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
 */