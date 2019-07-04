package zhen.swordoffer.Done;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class AfterOrderofBSF {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树：节点左子树的值都小于节点值，节点右子树的值都大于节点值
     * 后序遍历：最后一个数字是根节点，数组中的数字可分为两部分，一部分是左子树节点的值，一部分是右子树节点的值，然后两部分的最后一个数又是子树的根节点，递归
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        boolean result = isBST(sequence, 0, sequence.length - 1);
        return result;

    }

    public static boolean isBST(int[] arr, int start, int end) {
        if (start > end) return true;
        int i = end;
        while (i > start && arr[i - 1] > arr[end]) {
            i--;
        }
        for (int j = 0; j < i - 1; j++) {
            if (arr[j] > arr[end]) {
                return false;
            }
        }
        return isBST(arr, start, i - 1) && isBST(arr, i, end - 1);
    }

}
