package zhen.swordoffer.Done;


/**
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
public class GetNextNode {
    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {//当前节点有右子树，则下一节点就是右子树的最左节点
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {//没右子树，则下一节点就是父节点左孩子的节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;//只有根节点
    }
}

/**
        else if (pNode.next != null && pNode == pNode.next.left) {//当前节点无右子树,且是左节点，则下一节点就是当前节点的父节点
            return pNode.next;
        } else if(pNode.next != null && pNode == pNode.next.right){//当前节点无右子树,且是右节点，则下一节点就是当前节点的是其父节点左孩子的节点
            while(pNode.next!=null&&pNode.next.left!=pNode){
                pNode=pNode.next;
            }return pNode.next;
        }
        */
/**分三种情况讨论即可：
 * 1.当前节点有右子树，则下一节点就是右子树的最左节点
 * 2.当前节点无右子树,且是父节点的左节点，则下一节点就是当前节点的父节点
 * 3.当前节点无右子树,且是父节点的右节点，则下一节点就是沿着父节点一直向上遍历，直到当前节点的是其父节点的左节点，则当前节点的父节点即是下一节点
 * */