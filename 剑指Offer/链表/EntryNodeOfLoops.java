package zhen.swordoffer.Done;
/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 输出环中节点的个数
 */
public class EntryNodeOfLoops {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;//两个速度差一倍的指针，如果有环，必会在环内相遇
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)//判断是否有环，有环的话，找到fast和slow的相遇点
                break;
        }
        int nodeNum=0;
        if(fast==null||fast.next==null) return null;//判断没有环
        slow=pHead;//让一个指针从头开始走，一个从相遇点开始走，两个指针会在环的入口相遇
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
            nodeNum++;
        }
        return fast;
    }
}
/**
 * 断链法
 * if(pHead==null||pHead.next==null) return null;
 * ListNode fast=pHead.next;
 * ListNode slow=pHead;
 * while(fast!=null){
 * slow.next=null;
 * slow=fast;
 * fast=fast.next;
 * }
 * return slow;
 */
