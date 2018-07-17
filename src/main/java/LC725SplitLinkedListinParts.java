import Aux.ListNode;

public class LC725SplitLinkedListinParts {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
      ListNode[] parts = new ListNode[k];
      int len = 0;
      // find the length of the root
      for (ListNode node = root; node != null; node = node.next)
        len++;
      int n = len / k, r = len % k; // n : minimum guaranteed part size; r : extra nodes spread to the first r parts;
      ListNode node = root, prev = null;
      for (int i = 0; node != null && i < k; i++, r--) {
        parts[i] = node;
        for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
          prev = node;
          node = node.next;
        }
        prev.next = null;
      }
      return parts;
    }
  }
}