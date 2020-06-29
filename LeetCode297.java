import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。 你可以将以下二叉树：
 * 
 * 1 / \ 2 3 / \ 4 5
 * 
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 
 */
public class LeetCode297 {
    /**
     * 树的节点结构
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    public String serialize(TreeNode root, String str) {
        // 如果此节点为空 则添加null到字符串中 逗号分割
        if (root == null) {
            str += "null,";
        } else {
            // 前序遍历
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        // 返回转换好的字符串
        return str;
    }

    public TreeNode deserialize(String data) {
        // 通过逗号分割 转成字符串数组
        String[] stringArray = data.split(",");
        List<String> toSerialize = new ArrayList<>(Arrays.asList(stringArray));

        return deserialize(toSerialize);
    }

    public TreeNode deserialize(List<String> data) {
        // 如果当前节点为空 返回空节点
        if ("null".equals(data.get(0))) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data.get(0)));
        // 前序还原
        data.remove(0);
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }

    public static void main(String[] args) {
        // root
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        preOrder(node1, 0);
    }
}