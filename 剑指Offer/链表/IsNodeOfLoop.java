package zhen.swordoffer.Done;

/**检测链表是否有环,是检测链表的环的入口的基础
 * */
public class IsNodeOfLoop {
    public boolean IsLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (fast == null) return false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;//若存在环，则快慢指针必在环中相遇
        }
        return !(fast == null || fast.next == null);//快指针走到链表末尾处还没有追上慢指针，说明不存在环
    }
}
