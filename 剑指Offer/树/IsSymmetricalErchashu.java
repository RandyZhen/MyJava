package zhen.swordoffer.Done;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalErchashu {
    public static void main(String[] args) {

    }

    /**
     * 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return ischildSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean ischildSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return ischildSymmetrical(left.left, right.right) && ischildSymmetrical(left.right, right.left);
    }
}
