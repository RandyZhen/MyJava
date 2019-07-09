package zhen.swordoffer.Done;

/**
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/
public class IsBalanced {
    public static void main(String[] args) {

    }
    /**如果二叉树中任意结点的左右子树深度相差不超过1，那么它就是平衡二叉树。*/
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int left = GetTreeDepth(root.left);
        int right = GetTreeDepth(root.right);
        return Math.abs(left - right) <= 1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    public int GetTreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = GetTreeDepth(root.left);
        int right = GetTreeDepth(root.right);
        return (Math.max(left, right) + 1);
    }
}
/**
上面这种做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
 另一种思路：后序遍历时，遍历到一个节点，其左右子树已经遍历 ，依次自底向上判断，每个节点只需要遍历一次
public class Solution {
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;
    }
}
*/
