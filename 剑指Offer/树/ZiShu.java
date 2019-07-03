package zhen.swordoffer.Done;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class ZiShu {
    public static void main(String[] args) {
        TreeNode tree1 = null;
        TreeNode tree2 = null;
        System.out.println(HasSubtree(tree1, tree2));
    }

    /**
     * 思路：遍历A树，找到B的根节点（递归），若找不到则不是子结构，
     * 若可以找到，递归的判断它们各自的左右节点是否相等，递归终止条件：到达了树A或者B的叶节点
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {//递归的前提条件
            if (root1.val == root2.val) {//判断根节点是否相等，若相等，则递归判断各自的左右节点是否相等
                flag = DoesTree1HasTree2(root1, root2);
            }
            if (!flag) {//根节点不相等，则遍历树A的左右节点
                flag = HasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    public static boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
        }
        return false;
    }
}
