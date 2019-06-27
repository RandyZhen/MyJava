package zhen.swordoffer.Done;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */

import java.util.Arrays;

public class ChongJianErChaShu {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    public static zhen.swordoffer.Done.TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        zhen.swordoffer.Done.TreeNode node = new TreeNode(pre[0]);//找到根节点
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {//确定根节点在中序中的位置，找到左子树和右子树，递归
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

}
/**
 * 思路1：
 * 先序+中序--->>后序遍历
 * 根据先序和中序二叉树的性质，首先确定根节点及其位置，得左子树和右子树的先序和中序遍历，递归即可
 * <p>
 * Arrays.copyOfRange(T[ ] original,int from,int to)
 * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
 * 注意这里包括下标from，不包括上标to。
 */