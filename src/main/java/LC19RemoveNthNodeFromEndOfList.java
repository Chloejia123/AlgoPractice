import Aux.ListNode;

public class LC19RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for (int i = 1; i <= n + 1; i++) {
      fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
  }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;
    ListNode slow = head, fast = head;
    if (fast.next == null && n == 1) return null; // only one element in the list

    while (fast != null) {
      fast = fast.next;
      n--;
      if (n < -1) { // slow pointer stops at one node ahead
        slow = slow.next;
      }
    }
    if (n == 0) return head.next; // the length of linkedlist is equal to n

    else slow.next = slow.next.next;
    return head;
  }
}