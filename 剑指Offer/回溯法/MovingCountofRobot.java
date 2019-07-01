package zhen.swordoffer.Done;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCountofRobot {
    public static void main(String[] args) {

    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];//判断这个格子是否到达过
        return movingcount(threshold, rows, cols, 0, 0, flag);
    }

    private static int movingcount(int threshold, int rows, int cols, int i, int j, int[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] == 1 || (num(i) + num(j)) > threshold) return 0;//递归终止条件
        flag[i][j] = 1;
        return movingcount(threshold, rows, cols, i - 1, j, flag)
                + movingcount(threshold, rows, cols, i + 1, j, flag)
                + movingcount(threshold, rows, cols, i, j - 1, flag)
                + movingcount(threshold, rows, cols, i, j + 1, flag)
                + 1;
    }

    private static int num(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }
}
/**
 * 回溯法
 * 核心思路：
 * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
 * 返回1 + 4 个方向的探索值之和。
 * 2.探索时，判断当前节点是否可达的标准为：
 * 1）当前节点在矩阵内；
 * 2）当前节点未被访问过；
 * 3）当前节点满足limit限制
 */