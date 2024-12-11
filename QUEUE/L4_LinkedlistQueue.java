// using java collection framework
import java.util.*;
public class L4_LinkedlistQueue {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>(); //queue of integers using linkedlist
    Queue<Integer> q1 = new ArrayDeque<>(); //queue of integers using arrayDeque

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);

    while (!q.isEmpty()) {
      System.out.print(q.peek() + " -> ");
      q.remove();
    }
  }
}
