package zhen.example;

/**
 * 长度为n的绳子，把绳子剪成m段（n>1,m>1）,求出各段绳子的长度乘积的最大值
 */
public class Jianshengzi {
    public static void main(String[] args) {
        System.out.print(jianshengzi(8));
    }

    private static int jianshengzi(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res[] = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int len = res[j] * res[i - j];//动态规划
                if (len > max) {
                    max = len;
                }
                res[i] = max;
            }
        }
        max = res[n];
        return max;
    }
}
/**1.动态规划：f(n)=max(f(i)*f(n-i))
 * 2.贪婪算法：n>=5时，尽可能减长度为3的绳子
 *            n=4时，将绳子剪成2段长度为2的绳子
 *
 int timesof3=n/3;//n>=5时，尽可能减长度为3的绳子
     if(n-timesof3*3==1){//n=4时，将绳子剪成2段长度为2的绳子
          timesof3--;
          }
 int timesof2=(n-timesof3*3)/2;
 max=(int)(Math.pow(3,timesof3))*(int)(Math.pow(2,timesof2));

 *            */