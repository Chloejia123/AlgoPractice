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

  class Solution2 {
    public boolean isPalindrome(ListNode head) {
      if (head == null) return true;
      // detect the length
      int len = 0;
      for (ListNode p = head; p != null; p = p.next) len++;
      // reverse the first half list
      ListNode p = head, q = null, r = p.next;
      for (int i = 0; i < len / 2; i++) {
        p.next = q;
        q = p;
        p = r;
        r = r.next;
      }
      // detect the palindrome from the mid
      r = len % 2 == 0 ? p : r;
      while (r != null && q != null) {
        if (r.val != q.val) return false;
        r = r.next;
        q = q.next;
      }
      return r == null && q == null;
    }
  }
}


