// Q 6 : Queue Reversal
import java.util.*;
public class L9_QueueReversal {
  public static void QueueReversal(Queue<Integer> q) {
    Stack<Integer> s = new Stack<>();

    while (!q.isEmpty()) {
      s.push(q.remove());
    }

    while (!s.isEmpty()) {
      q.add(s.pop());
    }
  }
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>(); //queue of integers using linkedlist

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
   

    QueueReversal(q);
    // print the queue
    while (!q.isEmpty()) {
        System.out.print(q.peek() + " ");
        q.remove();
    }
  }
}
