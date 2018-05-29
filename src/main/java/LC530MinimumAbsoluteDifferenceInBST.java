import Aux.TreeNode;

public class LC530MinimumAbsoluteDifferenceInBST {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
      if (root == null) return min;
      // in order traversal
      getMinimumDifference(root.left);
      if (prev != null) {
        min = Math.min(min, Math.abs(root.val - prev));
      }
      prev = root.val;
      getMinimumDifference(root.right);
      return min;
    }
  }

}
