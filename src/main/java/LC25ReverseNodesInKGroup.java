import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Aux.ListNode;

public class LC25ReverseNodesInKGroup {
  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) {
      curr = curr.next;
      count++;
    }
    if (count == k) {
      curr = reverseKGroup(curr, k);
      while (count > 0) {
        ListNode tmp = head.next;
        head.next = curr;
        curr = head;
        head = tmp;
        count--;
      }
      head = curr;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode res = reverseKGroup(head,2);

    while (res != null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
  }
}
