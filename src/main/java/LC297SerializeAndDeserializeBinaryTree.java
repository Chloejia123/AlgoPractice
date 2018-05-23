import Aux.TreeNode;

public class LC297SerializeAndDeserializeBinaryTree {
  public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      buildString(root, sb);
      return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
      if (node == null)
        sb.append(NN).append(spliter);
      else {
        sb.append(node.val).append(spliter);
        buildString(node.left, sb);
        buildString(node.right, sb);
      }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      idx = 0;
      String[] arr = data.split(spliter);
      return buildTree(arr);
    }

    int idx = 0;

    public TreeNode buildTree(String[] arr) {
      String p = arr[idx++];
      if (p.equals(NN)) return null;
      TreeNode root = new TreeNode(Integer.parseInt(p));
      root.left = buildTree(arr);
      root.right = buildTree(arr);
      return root;
    }
  }
}
