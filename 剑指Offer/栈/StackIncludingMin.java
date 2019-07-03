package zhen.swordoffer.Done;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（min、pop、push时间复杂度应为O（1））。
 */

import java.util.*;

public class StackIncludingMin {
    /**
     * 思路：时间复杂度应为O（1），所以需要空间换时间（额外的空间降低时间的复杂度）
     * 构建两个辅助栈
     * 1：data依次存放入栈的元素数值
     * 2：min保存依次入栈最小的数
     * 3.依次入栈时，元素值比min.peek()小的时候，入min栈，否则入data栈
     * 例如：data中依次入栈，5,  4,  3, 8, 10, 11, 12
     * 则min依次入栈，5,  4,  3，no, no, no, 1
     * no代表此次不如栈
     * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
     */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            if (node <= min.peek()) min.push(node);
        }

    }

    public void pop() {
        int top = data.peek();
        data.pop();
        if(top==this.min()){
            min.pop();
        }
    }

    public int top() {
        int top = data.peek();
        data.pop();
        if(top==this.min()){
            min.pop();
        }
       return top;

    }

    public int min() {
        if(min.isEmpty())
            return Integer.MAX_VALUE;
        else
            return min.peek();

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        /*min(stack);*/
    }

}
