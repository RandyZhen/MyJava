package zhen.swordoffer.Done;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeErchashu {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历实现序列化，碰到节点为空null时，序列化为#！，数值之间用！隔开，递归
     */
    public String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        pre(root, builder);
        return builder.toString();
    }

    /**
     * 递归实现前序遍历
     */
    public void pre(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#!");
        } else {
            builder.append(root.val + "!");
            pre(root.left, builder);
            pre(root.right, builder);

        }
    }

    /**
     * 递归实现反序列化
     */
    int index = -1;
    public TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) return null;
        String[] nodes = str.split("!");//得到所有的节点值
        TreeNode node = null;
        if (!nodes[index].equals("#")) {//非空节点
            node = new TreeNode(Integer.parseInt(nodes[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
