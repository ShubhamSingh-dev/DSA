import java.util.*;
public class L12_QueueUsingDeque {
  public static class Queue {
    Deque<Integer> d = new LinkedList<>();

    public void add(int data) {
      d.addLast(data);
    }

    public int remove() {
      if (d.isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      return d.removeFirst();
    }

    public int peek() {
      if (d.isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      return d.getFirst();
    }

  }
  public static void main(String[] args) {
    Queue q = new Queue();

    q.add(1); 
    q.add(2); 
    q.add(3); 
    System.out.println(q.remove()); 
    q.add(4); 
    System.out.println(q.remove());
    System.out.println(q.peek());
    
    
  }
}
