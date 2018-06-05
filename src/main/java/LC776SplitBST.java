import Aux.TreeNode;

public class LC776SplitBST {
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
    public TreeNode[] splitBST(TreeNode root, int V) {
      TreeNode[] splitted = new TreeNode[]{null, null};
      if (root == null) return splitted;

      if (root.val <= V) {
        splitted = splitBST(root.right, V);
        root.right = splitted[0];
        splitted[0] = root;
      } else {
        splitted = splitBST(root.left, V);
        root.left = splitted[1];
        splitted[1] = root;
      }

      return splitted;
    }
  }


}
