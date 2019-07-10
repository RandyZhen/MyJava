package zhen.swordoffer.Done;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
        对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
        例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateStringT {
    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 4;
        LeftRotateStringT lt = new LeftRotateStringT();
        System.out.println(lt.LeftRotateString(str, n));
    }

    /**
     * 思路：
     * 1.先翻转前半部分
     * 2.再翻转后半部分
     * 3.再对字符串整个进行翻转
     * <p>
     * 考点：不使用库对字符串进行灵活的翻转
     */
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) return "";
        char[] ch = str.toCharArray();
        reverseString(ch, 0, n - 1);
        reverseString(ch, n, str.length() - 1);
        reverseString(ch, 0, str.length() - 1);
        return new String(ch);
    }

    /**
     * 对字符数组 ch 的 start 到 end 范围内的字符进行翻转
     */
    public void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

}
/**

利用字符串翻转。YX = (XTYT)T
假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。
假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果.
    public String LeftRotateString(String str,int n) {
        int len=str.length();
        if(str.length()==0) return "";
        char[] ch = str.toCharArray();
         n %= len;
        for(int i = 0, j = n - 1; i < j; ++i, --j)  reverseString(ch, i, j);
        for(int i = n, j = len - 1; i < j; ++i, --j)  reverseString(ch, i, j);
        for(int i = 0, j = len - 1; i < j; ++i, --j)  reverseString(ch, i, j);
        return new String(ch);
    }
    public void reverseString(char[] ch, int start, int end) {

            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

    }

另一种思路：
        int len=str.length();
        if(len==0) return "";
        n=n%len;
        str+=str;
        return str.substring(n,len+n);
另二种思路：
        if(str.length()==0)  return "";
   //把原字符串截取成俩字符串，然后拼接
        n=n%str.length();
   String s1 = str.substring(0, n);
   String s2 = str.substring(n,str.length());
   return s2 + s1;

另三种思路：
public String LeftRotateString(String str,int n) {
        if (str == null || n < 0 || n > str.length()) return null;
        StringBuilder sb = new StringBuilder(str);
        sb.append(sb.substring(0, n));
        return sb.substring(n, sb.length());
    }
                */
