import Aux.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }
  private int dfs(TreeNode node, int n){
    if(node == null) return 0;
    if(node.left == null && node.right == null) return n*10 + node.val;
    return dfs(node.left, n*10 + node.val) + dfs(node.right, n*10 + node.val);
  }
}