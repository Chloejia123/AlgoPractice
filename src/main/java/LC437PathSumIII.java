public class LC437PathSumIII {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int dfs(TreeNode node, int sum) {
    if (node == null) {
      return 0;
    }
    return (node.val == sum ? 1 : 0) + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
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
