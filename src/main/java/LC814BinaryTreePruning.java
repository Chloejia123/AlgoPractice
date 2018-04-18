public class LC814BinaryTreePruning {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    return (root.val == 1 || root.left != null || root.right != null) ? root : null;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
