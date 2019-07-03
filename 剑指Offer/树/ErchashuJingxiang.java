package zhen.swordoffer.Done;


/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class ErchashuJingxiang {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        Mirror(tree1);
    }

    /**
     * 思路：前序遍历树的节点，如果节点有子节点，则交换这两个子节点。
     */
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode treeTemp = root.right;//交换节点的左右子节点
        root.right = root.left;
        root.left = treeTemp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }

    }
}
