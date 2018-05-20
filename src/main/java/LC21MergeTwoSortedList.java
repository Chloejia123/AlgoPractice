import Aux.ListNode;

public class LC21MergeTwoSortedList {
  // iterative solution
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode res = new ListNode(0);
    ListNode prev = res;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    if (l1 != null) {
      prev.next = l1;
    }
    if (l2 != null) {
      prev.next = l2;
    }
    return res.next;
  }

  // recursive solution
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode res;
    if (l1.val <= l2.val) {
      res = l1;
      res.next = mergeTwoLists(l1.next, l2);
    } else {
      res = l2;
      res.next = mergeTwoLists(l1, l2.next);
    }
    return res;
  }
}
