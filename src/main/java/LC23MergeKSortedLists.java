import java.util.Comparator;
import java.util.PriorityQueue;

import Aux.ListNode;

public class LC23MergeKSortedLists {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        if (l1.val < l2.val) {
          return -1;
        } else if (l1.val > l2.val) {
          return 1;
        }
        return 0;
      }
    });

    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    for (ListNode ln : lists) {
      if (ln != null)
        pq.offer(ln);
    }

    while (!pq.isEmpty()) {
      prev.next = pq.poll();
      prev = prev.next;

      if (prev.next != null) {
        pq.offer(prev.next);
      }
    }
    return dummy.next;
  }
}
