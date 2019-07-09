package zhen.swordoffer.Done;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class FindKthNode {
    public static void main(String[] args) {

    }

    /**二叉搜索树：左子树的只小于根节点，右子树的值大于根节点
     * 所以二叉搜索树的中序遍历，得到节点值的递增排序，找到第k个即可
     */
    /*非递归中序遍历*/
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }
}
/**
 * 递归思路
 * <p>
 * public TreeNode KthNode(TreeNode pRoot, int k) {
 * if (pRoot == null || k == 0) return null;
 * TreeNode node = KthNode(pRoot.left, k);
 * if (node != null) return node;
 * if (++count == k) return pRoot;
 * node = KthNode(pRoot.right, k);
 * if (node != null) return node;
 * return null;
 * }
 */
