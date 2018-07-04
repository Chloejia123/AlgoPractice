import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {
  class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
      map = new HashMap<Integer, Node>(capacity);
      this.capacity = capacity;

      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.pre = head;
    }

    public int get(int key) {
      int res = -1;
      if (map.containsKey(key)) {
        Node n = map.get(key);
        removeNode(n);
        insertToHead(n);
        res = n.val;
      }
      return res;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node n = map.get(key);
        removeNode(n);
        n.val = value;
        insertToHead(n);
      } else {
        if (map.size() == capacity) {
          map.remove(tail.pre.key);
          removeNode(tail.pre);
        }
        Node n = new Node(key, value);
        insertToHead(n);
        map.put(key, n);
      }
    }

    private void removeNode(Node n) {
      n.pre.next = n.next;
      n.next.pre = n.pre;
    }

    private void insertToHead(Node n) {
      Node headNext = head.next;
      head.next = n;
      headNext.pre = n;
      n.pre = head;
      n.next = headNext;
    }

    class Node {
      int key;
      int val;
      Node pre;
      Node next;

      // constructor
      public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
      }
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
