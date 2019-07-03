package zhen.swordoffer.Done;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ShunshizhenPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 4}, {3, 5, 7}, {6, 8, 9}};
        System.out.println(printMatrix(matrix));
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0 || m == 0) {
            return arrayList;
        }
        int layer = (Math.min(n, m) - 1) / 2 + 1;
        for (int i = 0; i < layer; i++) {
            for (int k = i; k < m - i; k++) arrayList.add(matrix[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) arrayList.add(matrix[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) arrayList.add(matrix[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) arrayList.add(matrix[j][i]);//左下至左上
        }
        return arrayList;
    }
}
