package zhen.swordoffer.Done;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
        例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
        */
public class IsNumericOfString {
    public static void main(String[] args) {
        char[] str=new char[10];
        IsNumericOfString a=new IsNumericOfString();
        a.isNumeric(str);
    }
/**字符串遵循模式A.[.[B]][e|EC]或者.B[e|EC]*/
    public boolean isNumeric(char[] str) {
        if (str == null) return false;
        int len = str.length;
        boolean sign = false, decimal = false, hasE = false;// 标记符号、小数点、e是否出现过
        for (int i = 0; i < len; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == len - 1) return false;//e不能出现在最后一位
                if (hasE) return false; //不能连续出现两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;// 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;// 第二次出现+-符号，则必须紧接在e之后
                sign = true;
            } else if (str[i] == '.') {
                if (hasE)
                    return false;// e后面不能接小数点，小数点不能出现两次
                if (decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') { // 不合法字符
                return false;
            }
        }
        return true;
    }
}
/**


//正则表达式解法
 字符串模式为A.[.[B]][e|EC]或者.B[e|EC] 其中A，B为整数，可以有正负号，也可以没有，B是无符号整数
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
/*
以下对正则进行解释:
[\\+\\-]?            -> 正或负符号出现与否
\\d*                 -> 整数部分A是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字B；
                        否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                        紧接着必须跟着整数C；或者整个部分都不出现
*/