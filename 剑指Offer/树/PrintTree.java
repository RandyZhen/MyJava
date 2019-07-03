package zhen.swordoffer.Done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTree {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> quene = new LinkedList<>();
        if (root == null) return arrayList;
        quene.add(root);
        while (quene.size() != 0) {
            TreeNode temp = quene.remove();
            if (temp.left != null) {
                quene.add(temp.left);
            }
            if (temp.right != null) {
                quene.add(temp.right);
            }
            arrayList.add(temp.val);
        }

        return arrayList;
    }
}
/**
 * 实际就是广度优先搜索 BFS,
 * 思路还是很清晰的，使用两个队列一个存放节点，一个存放值。
 * 先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来
 */
