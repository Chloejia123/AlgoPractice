import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Aux.TreeNode;

public class LC545BoundaryOfBinaryTree {
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
    private boolean isLeaf(TreeNode node) {
      return node.left == null && node.right == null;
    }

    private void addLeaves(List<Integer> list, TreeNode root) {
      if (isLeaf(root)) {
        list.add(root.val);
      } else {
        if (root.left != null) {
          addLeaves(list, root.left);
        }
        if (root.right != null) {
          addLeaves(list, root.right);
        }
      }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
      List<Integer> res = new LinkedList<>();
      if (root == null) return res;
      // add root
      if (!isLeaf(root)) {
        res.add(root.val);
      }
      // add left boundary
      TreeNode t = root.left;
      while (t != null) {
        if (!isLeaf(t)) {
          res.add(t.val);
        }
        if (t.left != null) {
          t = t.left;
        } else {
          t = t.right;
        }
      }

      // add leaves
      addLeaves(res, root);

      // add right boundary
      Stack<Integer> stack = new Stack<>();
      TreeNode r = root.right;
      while (r != null) {
        if (!isLeaf(r)) {
          stack.push(r.val);
        }
        if (r.right != null) {
          r = r.right;
        } else {
          r = r.left;
        }
      }
      while (!stack.isEmpty()) {
        res.add(stack.pop());
      }
      return res;
    }
  }
}
