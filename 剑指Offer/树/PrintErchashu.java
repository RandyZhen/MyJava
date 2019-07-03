package zhen.swordoffer.Done;
/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.ArrayList;
import java.util.Stack;

public class PrintErchashu {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return null;
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> Arraylist = new ArrayList<>();
        s1.push(pRoot);
        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {//奇数层，从左都右
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        arrayList.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Arraylist.add(arrayList);
                    layer++;
                }
            } else {//偶数层，从右到左
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        arrayList.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Arraylist.add(arrayList);
                    layer++;
                }
            }

        }
        return Arraylist;

    }
}
