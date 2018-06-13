import Aux.TreeNode;

public class LC226InvertBinaryTree {
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
    public TreeNode invertTree(TreeNode root) {
      if (root == null) return root;
      TreeNode cur = root;

      // swap the left and right
      TreeNode temp = cur.left;
      cur.left = cur.right;
      cur.right = temp;

      cur.left = invertTree(cur.left);
      cur.right = invertTree(cur.right);
      return root;
    }
  }
}
