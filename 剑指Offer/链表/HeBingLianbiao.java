package zhen.swordoffer.Done;


/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class HeBingLianbiao {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list = null;
        if (list1.val <= list2.val) {
            list = list1;
            list.next = Merge(list1.next, list2);
        } else {
            list = list2;
            list.next = Merge(list1, list2.next);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(2);
        System.out.println(Merge(listNode, listNode1));

    }
}
/**我们首先比较两个链表的头结点的值，小的那个就是合并列表的头结点，
 * 继续合并两个链表中剩余的节点，会发现步骤和前面一样的，递归即可*/