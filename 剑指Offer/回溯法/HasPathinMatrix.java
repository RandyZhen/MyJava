package zhen.swordoffer.Done;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPathinMatrix {
    public static void main(String[] args) {

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];//用一个状态数组保存之前访问过的字符
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {//循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (haspath(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    //haspath(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位,标志位)
    private boolean haspath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j; //先根据i和j计算匹配的第一个元素转为一维数组的位置
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)//递归终止条件
            return false;
        if (k == str.length - 1) return true;//若k已经到达str末尾了，说明之前的都已经匹配成功了matrix[index] = str[str.length-1] ，直接返回true即可
        flag[index] = 1; //要走的第一个位置置为1，表示已经走过了
        if (haspath(matrix, rows, cols, i - 1, j, str, k + 1, flag)//递归寻找，每次找到了就给k加一，找不到，还原
                || haspath(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || haspath(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || haspath(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;//回溯,走到这，说明这一条路不通，还原，再试其他的路径
        return false;
    }
}
/**
 * 回溯
 *  这是一个可以用回溯法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
 * 第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
 * 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
 * 　　由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
 * 字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
 * 　　由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
 * 格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
 * 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
 * 　　一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置.
 *
 * 基本思想：
 * 0.根据给定数组，初始化一个标志位数组，初始化为0，表示未走过，1表示已经走过，不能走第二次
 * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入haspath
 * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
 * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
 * 4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
 * 5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
 * 6.走到 flag[index] = 0;这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
 */