package zhen.swordoffer.Done;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ZiFuTiHuan {
    public static void main(String[] args) {
        StringBuffer arrays = new StringBuffer("I am very happy");
        System.out.println(replaceSpace2(arrays));
        /* System.out.println(arrays.replaceAll(" ","20%"));*/
    }
    /**方法1：利用Stringbuffer的append属性*/
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer strr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                strr.append(str.charAt(i));
            } else {
                strr.append('%');
                strr.append('2');
                strr.append('0');
            }
        }
        return strr.toString();
    }

    /**
     * 方法2：
     * 在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
     * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点-----此种思路可用于两个有序数组合并-从后向前
     */
    public static String replaceSpace2(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') spaceNum++;//字符串的空格个数
        }
        int i = str.length() - 1;
        int len = str.length() + 2 * spaceNum - 1;//替换之后的字符串长度的下标
        str.setLength(len + 1);
        for (; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(len--, str.charAt(i));
            } else {
                str.setCharAt(len--, '0');
                str.setCharAt(len--, '2');
                str.setCharAt(len--, '%');
            }
        }
        //System.out.print(str.toString());
        return str.toString();
    }
}