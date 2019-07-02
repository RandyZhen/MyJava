package zhen.swordoffer.Done;
/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class deleteDuplicationNode {
    public static void main(String[] args) {

    }

    /**
     * 非递归方法：当前节点与下一节点值相同，则都被删除，当前节点的上一节点指针指向比当前节点的值不同的下个节点，确保链表不断
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode first = new ListNode(0);
        first.next = pHead;
        ListNode p = pHead;//新建一个头节点，以防第一个节点被删除。
        ListNode pre = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {//当前节点与下一节点值相同,则都被删除
                int val = p.val;
                while (p != null && p.val == val)//一直找到与当前节点值不同的下一节点
                    p = p.next;
                pre.next = p;//当前节点的上一节点指针指向比当前节点的值不同的下个节点，确保链表不断
            } else {
                pre = p;
                p = p.next;
            }
        }
        return first.next;
    }

    /**
     * 递归方法
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        if (pHead.val == pHead.next.val) {//当前节点是重复节点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;//找到与当前节点不同的下一个节点
            }
            return deleteDuplication(pNode);//从与当前节点不同的下一个节点开始递归
        } else {//当前节点不是重复节点，从下一个节点递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
/**
 * 引申
 * 删除链表中的指定的节点(考虑删除节点为头结点)
 * O(n)时间：从头结点开始遍历，找到要删除节点的前一节点，把指针指向删除节点的下一节点即可
 * O(1)时间：把要删除节点的下一节点的内容复制到删除节点，要删除节点的指针指向下一节点的下一节点，然后删除要删除节点的下一节点即可（删除节点为尾节点，只能从头遍历）
 * public void deleteNode(ListNode node) {
 *      node.val = node.next.val;
 *      node.next = node.next.next;
 * }
 */