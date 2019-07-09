package zhen.swordoffer.Done;


import java.util.Queue;
import java.util.LinkedList;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class TreeDepthOfShu {
    public static void main(String[] args) {

    }

    /**
     * 1.非递归版本（层次遍历）
     * 经典的非递归层次遍历：利用辅助队列，先将头节点入队列，当队列不空时出队列的节点记为current，
     * 当current左节点不空时入队列，其右节点不空时入队列，如此循环即可。
     * 求深度：构造变量cur记录当前层访问到的节点数，width记录当前层的总个数，每当访问过一层 depth++；
     * 此种方法同时可以求最大宽度，访问第几层的第几个节点，是一种通用方法！
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  //构造辅助队列
        int cur, width;           //cur记录访问到当前层的第几个,width为当前层的总个数
        int depth = 0;            //初始深度为0；
        queue.offer(root);          //头结点入队列
        while (!queue.isEmpty()) {        //队列不空 循环记录深度
            cur = 0;                                //新的一层cur赋为0
            width = queue.size();           //当前队列里的节点即为该层的所有节点
            while (cur < width) {               //循环访问该层的所有节点
                TreeNode current = queue.poll();    //访问队列的头
                if (current.left != null)       //左节点不空，左节点入队列
                    queue.offer(current.left);
                if (current.right != null)     //右节点不空，右节点入队列
                    queue.offer(current.right);
                cur++;           //访问完当前节点后cur++
            }
            depth++;            //访问完一层，层数++;
        }
        return depth;

    }
}
/**
 * 2.递归版本（层次遍历）
 * 如果该树只有一个结点，它的深度为1.
 * 如果根节点只有左子树没有右子树，那么树的深度为左子树的深度加1；
 * 同样，如果只有右子树没有左子树，那么树的深度为右子树的深度加1。
 * 如果既有左子树也有右子树，那该树的深度就是左子树和右子树的最大值加1.
 * public int TreeDepth(TreeNode root) {
 * if (root == null) return 0;
 * int left=TreeDepth(root.left);
 * int right=TreeDepth(root.right);
 * int count = Math.max(left,right)+1;
 * return count;
 * }
 */