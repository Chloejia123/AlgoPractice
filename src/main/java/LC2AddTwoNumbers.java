import Aux.ListNode;

public class LC2AddTwoNumbers {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode cur1 = l1, cur2 = l2;
      ListNode nodeptr = new ListNode(0);
      ListNode cur = nodeptr;
      int carry = 0;
      while (cur1 != null || cur2 != null || carry != 0) {
        int v1 = cur1 == null ? 0 : cur1.val;
        int v2 = cur2 == null ? 0 : cur2.val;

        int sum = (v1 + v2 + carry) % 10;
        carry = (v1 + v2 + carry) / 10;
        cur1 = cur1 == null ? cur1 : cur1.next;
        cur2 = cur2 == null ? cur2 : cur2.next;
        ListNode node = new ListNode(sum);
        cur.next = node;
        cur = cur.next;
      }
      return nodeptr.next;
    }
  }
}
