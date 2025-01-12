import java.util.*;

public class L11_StackUsingDeque {

  public static class Stack {
    Deque<Integer> d = new LinkedList<>();

    public void push(int data) {
      d.addLast(data);
    }

    public int pop() {
      return d.removeLast();
    }

    public int peek() {
      return d.peekLast();
    }
  }

  public static void main(String[] args) {
    Stack s = new Stack();

    s.push(1);
    s.push(2);
    s.push(3);

    while (!s.d.isEmpty()) {
      System.out.print(s.peek() + " ");
      s.pop();
    }
  }
}
