import java.util.LinkedList;
import java.util.List;

import LeetCode297.TreeNode;


public class LeetCode257 {
    protected class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private Integer val;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->" , res);
    }
}
