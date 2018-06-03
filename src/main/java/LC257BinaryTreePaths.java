import java.util.ArrayList;
import java.util.List;

import Aux.TreeNode;

public class LC257BinaryTreePaths {
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
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> paths = new ArrayList<>();
      if (root == null) return paths;

      List<String> left = binaryTreePaths(root.left);
      List<String> right = binaryTreePaths(root.right);

      if (root.left == null && root.right == null) {
        paths.add("" + root.val);
      }
      for (String path : left) {
        paths.add("" + root.val + "->" + path);
      }
      for (String path : right) {
        paths.add("" + root.val + "->" + path);
      }
      return paths;
    }
  }
}
