package zhen.example;

/**
 * 把数字翻译成字符串(0-25翻译成a-z)
 */
public class ChangeNumToString {
    public static int getTranslationCount(int number) {
        if (number < 0)
            return 0;
        if (number == 1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }

    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String number) {
        int f1 = 0, f2 = 1, g = 0;
        int temp;
        for (int i = number.length() - 2; i >= 0; i--) {
            if (Integer.parseInt(number.charAt(i) + "" + number.charAt(i + 1)) < 26)
                g = 1;
            else
                g = 0;
            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }
}
/*
自上而下，从最大的问题开始，递归 ：
                     12258
                   /       \
              b+2258       m+258
              /   \         /   \
          bc+258 bw+58  mc+58  mz+8
          /  \      \        \     \
      bcc+58 bcz+8   bwf+8   mcf+8  mzi
        /        \       \     \
   bccf+8        bczi    bwfi   mcfi
     /
 bccfi
有很多子问题被多次计算，比如258被翻译成几种这个子问题就被计算了两次。

自下而上，动态规划，从最小的问题开始 ：
f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。
递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
因此，对于12258：
f(5) = 0
f(4) = 1
f(3) = f(4)+0 = 1
f(2) = f(3)+f(4) = 2
f(1) = f(2)+f(3) = 3
f(0) = f(1)+f(2) = 5

*/