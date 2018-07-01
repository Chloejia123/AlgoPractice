import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Aux.ListNode;

public class LC234PalindromeLinkedList {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public boolean isPalindrome(ListNode head) {
      if (head == null) return true;
      Stack<ListNode> stack = new Stack<>();
      Queue<ListNode> queue = new LinkedList<ListNode>();
      ListNode copy = head;
      while (copy != null) {
        stack.push(copy);
        copy = copy.next;
      }

      while (head != null) {
        queue.add(head);
        head = head.next;
      }
      while (!stack.isEmpty()) {
        if (stack.peek().val == queue.peek().val) {
          stack.pop();
          queue.poll();
        } else
          return false;
      }
      return true;
    }
  }
}
