package zhen.swordoffer.Done;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

import java.util.Stack;

public class ZhanToDuilie {

    Stack<Integer> stack1 = new Stack<>();//stack1提供入栈功能
    Stack<Integer> stack2 = new Stack<>();//stack2提供出栈功能

    public void push(int node) {
        stack1.push(node);//入队列，则入栈stack1即可
    }

    public int pop() {//出队列，分为两种情况  1：stack2不为空，则直接出栈；2：stack2为空，则依次pop出stack1的数据，放入stack2中，再从stack2出栈
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }

}
/**
 * 如何用两个队列来实现一个栈
 * 思路：队列a提供入栈功能；队列b提供出栈功能
 * 入栈时，直接入队列a即可
 * 出栈时，分为两种情况：1：队列a只有一个元素：直接出队列输出即可
 *                    2：队列a不只有一个元素，把队列a所有元素出队列，然后依次入队列b，最后一个元素不入队列b，输出该元素，然后将队列b的所有元素入队列a
 */