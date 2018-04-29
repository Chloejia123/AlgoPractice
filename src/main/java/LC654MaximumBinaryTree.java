import Aux.TreeNode;

public class LC654MaximumBinaryTree {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums.length == 0 || nums == null) return null;
    TreeNode root = helper(nums, 0, nums.length - 1);
    return root;
  }

  private TreeNode helper(int[] nums, int lo, int hi) {
    if (lo > hi) return null;
    int maxInd = lo;
    for (int i = lo + 1; i <= hi; i++) {
      if (nums[i] > nums[maxInd]) {
        maxInd = i;
      }
    }
    TreeNode node = new TreeNode(nums[maxInd]);

    node.left = helper(nums, lo, maxInd - 1);
    node.right = helper(nums, maxInd + 1, hi);
    return node;
  }

}
