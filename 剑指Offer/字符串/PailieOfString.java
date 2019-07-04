package zhen.swordoffer.Done;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PailieOfString {
    public static void main(String[] args) {
        String arr = "abcd";
        System.out.println(Permutation(arr));
    }

    /**
     * 思路1：递归
     * 把字符串分为两部分，一部分是字符串的第一个字符，一部分是剩余所有字符，递归求剩余字符的全排列，
     * 拿第一个字符和它后面的字符逐个交换，同样递归
     */
/**
    public ArrayList<String> Permutation(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);//将第一个字符和其他字符交换位置
                    PermutationHelper(chars,i+1,list);//递归
                    swap(chars,j,i);//第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序
                }
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
 */
    /**
     * 思路2：回溯法，见下面分析
     * */
    public static ArrayList<String> Permutation(String str) {
        List<String> resultList = new ArrayList<>();
        if (str.length() == 0) return (ArrayList) resultList;
        fun(str.toCharArray(), resultList, 0);//递归的初始值为（str数组，空的list，初始下标0）
        Collections.sort(resultList);
        return (ArrayList) resultList;
    }
    public static void fun(char[] ch, List<String> list, int i) {
        if (i == ch.length - 1) {//这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
            if (!list.contains(new String(ch))) {//判断一下是否重复
                list.add(new String(ch));
                return;
            }
        } else {
            for (int j = i; j < ch.length; j++) {
                swap(ch, i, j);
                fun(ch, list, i + 1);
                swap(ch, i, j);
            }
        }
    }
    public static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}

/**
 * 这一段就是回溯法，这里以"abc"为例
 * 递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行
 * <p>
 * //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
 * //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
 * //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
 * /////////////-------》此时结果集为["abc"]
 * <p>
 * //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
 * //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
 * /////////////-------》此时结果集为["abc","acb"]
 * //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,0)
 * //               |
 * //             a|b|c(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         a|b|c   a|c|b
 * <p>
 * //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
 * /////////////-------》此时结果集为["abc","acb","bac","bca"]
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,1)
 * //               |
 * //             b|a|c(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         b|a|c   b|c|a
 * <p>
 * //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
 * /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,2)
 * //               |
 * //             c|b|a(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         c|b|a   c|a|b
 * <p>
 * //5.最后退出for循环，结束。
 */