package zhen.swordoffer.Done;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */


public class MultiplyShuzu {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(multiply(A));
    }

    /**
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     */
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        while (len != 0) {
            res[0] = 1;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int j = len - 2; j >= 0; j--) {
                temp *= A[j + 1];
                res[j] *= temp;
            }
        }
        return res;
    }
}

/**
另一种思路：
    int[] res = new int[A.length];
    int result = 1;
        for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A.length; j++) {
        if (j != i) {
        result *= A[j];
        }
        }
        res[i] = result;
        result = 1;
        }
        return res;
*/
