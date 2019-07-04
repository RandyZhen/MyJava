package zhen.swordoffer.Done;
/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
import java.util.ArrayList;

public class FindPathToSum {
    public static void main(String[] args) {

    }

    /**前序遍历访问节点，并把节点添加到路径上，累加该节点的值，如果为叶节点且累加值刚好等于输入整数，路径符合要求；
     * 访问到叶节点后，递归函数回到父节点，在函数退出前需要在路径上删除节点并减去节点值*/
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {//为叶节点且累加值刚好等于输入整数，路径符合要求
            listAll.add(new ArrayList<>(list));//因为add添加的是引用，如果不new一个的话，后面的操作会更改这个list
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);//递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        return listAll;

    }
}
