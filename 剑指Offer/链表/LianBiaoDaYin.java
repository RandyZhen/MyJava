package zhen.swordoffer.Done;
/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
import java.util.ArrayList;

public class LianBiaoDaYin {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int size = 2;
        ListNode listNode = new ListNode(size);
        listNode.val = 11;
        listNode.val = 2;
        printListFromTailToHead(listNode);
        System.out.println(printListFromTailToHead(listNode));
    }
}
/**思路1：利用栈Stack先进后出的特性
 *     public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
 *         ArrayList<Integer> arrayList = new ArrayList<>();
 *         Stack<ListNode> sk=new Stack<>();
 *         while(listNode!=null){
 *             sk.push(listNode);
 *             listNode=listNode.next;
 *         }
 *         while(listNode!=null){
 *             arrayList.add(sk.pop().val);
 *         }
 *              return arrayList;
 *     }
 * 思路2；利用递归(递归在本质上就是栈结构)
 * 访问一个节点的时候，先递归输出它后面的节点，再输出该节点本身，这样链表就可以从尾到头输出了
 *     public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
 *         ArrayList<Integer> arrayList = new ArrayList<>();
 *         if (listNode != null) {
 *             printListFromTailToHead(listNode.next);
 *             arrayList.add(listNode.val);
 *         }
 *         return arrayList;
 *     }
 *
 *
 * */
