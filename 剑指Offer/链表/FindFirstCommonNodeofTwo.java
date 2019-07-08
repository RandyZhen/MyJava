package zhen.swordoffer.Done;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNodeofTwo {
    public static void main(String[] args) {

    }

    /**
     * 思路：两个链表相交，则从第一个公共节点开始，所有节点都是重合的
     * 把两个链表的节点分别放进两个栈中，只需要比较栈顶的元素即可
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        ListNode listNode = null;
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            stack2.pop();
            listNode = stack1.pop();
        }
        return listNode;

    }
}
/**
 * ListNode p1 = pHead1;
 * ListNode p2 = pHead2;
 * while (p1 != p2) {
 * if (p1 != null) p1 = p1.next;
 * if (p2 != null) p2 = p2.next;
 * if (p1 != p2) {
 * if (p1 == null) p1 = pHead2;
 * if (p2 == null) p2 = pHead1;
 * }
 * }
 * return p1;
 */
