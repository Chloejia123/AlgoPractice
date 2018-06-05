import Aux.ListNode;

public class LC237DeleteANodeInALinkedList {
  class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val; // 把当前值变成next node的值， 然后把next Node给跳过（删除）
      node.next = node.next.next;
    }
  }
}
