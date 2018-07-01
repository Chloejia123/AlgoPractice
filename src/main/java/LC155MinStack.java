import java.util.Stack;

public class LC155MinStack {
  class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
      if (stack2.isEmpty() || x <= stack2.peek()) {
        stack2.push(x);
      }
      stack1.push(x);
    }

    public void pop() {
      if (stack1.peek().equals(stack2.peek()))
        stack2.pop();
      stack1.pop();
    }

    public int top() {
      return stack1.peek();
    }

    public int getMin() {
      return stack2.peek();
    }
  }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
