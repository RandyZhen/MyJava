package zhen.swordoffer.Done;
/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintErchashuMul {

    /**规律：先把头结点放入队列，每次从队列头部取出打印节点时，把此节点的左右节点（如果有）放入队列尾部，接着从队列头部取出最早进入队列的节点*/
    ArrayList<ArrayList<Integer>> Print(zhen.swordoffer.TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();/*队列LinkedList完成层序遍历，用end记录每层结点数目*/
        if (pRoot == null) return result;
        Queue<zhen.swordoffer.TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode cur = layer.remove();//取出队列头部的节点
            layerList.add(cur.val);//把节点值放入每一层的layerList中
            start++;
            if (cur.left != null) layer.add(cur.left);//把从队列头取出节点的左右节点（如果有）放入队列尾部
            if (cur.right != null) layer.add(cur.right);
            if (start == end) {//相等表示这一层的节点打印完毕，目的是把二叉树打印成多行
                end = layer.size();
                start = 0;
                result.add(layerList);//把每一层的节点值组合放进结果中
                layerList = new ArrayList<>();
            }
        }
        return result;
    }

}
/*
* 上一题的思路：
* ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        Stack<Integer>  s3=new Stack<>();
        ArrayList<ArrayList<Integer>> Arraylist = new ArrayList<>();
        s1.push(pRoot);
        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {//奇数层，从左都右
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        arrayList.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Arraylist.add(arrayList);
                    layer++;
                }
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        arrayList.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                int len=arrayList.size();
                while(!arrayList.isEmpty()){
                    s3.push(arrayList.get(0));
                    arrayList.remove(0);
                }
                for(int i=0;i<len;i++){
                    arrayList.add(s3.pop());
                }
                if (!arrayList.isEmpty()) {
                    Arraylist.add(arrayList);
                    layer++;
                }

            }

        }
        return Arraylist;

    }
    */