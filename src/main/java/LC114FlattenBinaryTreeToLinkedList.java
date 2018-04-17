public class LC114FlattenBinaryTreeToLinkedList {
  private TreeNode prev = null;

  public void flatten(TreeNode root) {
    if (root == null)
      return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
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
