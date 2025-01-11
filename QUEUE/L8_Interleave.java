// question 5 : Interleave 2 halves of a queue(even length)
 import java.util.*;
public class L8_Interleave {
  public static void Interleave(Queue<Integer> q){
    Queue<Integer> firstHalf = new LinkedList<>();
    int size = q.size();

    for(int i = 0; i < size/2; i++){
      firstHalf.add(q.remove());
    }

    while(!firstHalf.isEmpty()){
      q.add(firstHalf.remove());
      q.add(q.remove());
    }
  }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); //queue of integers using linkedlist
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7); 
        q.add(8);
        q.add(9);
        q.add(10);

        Interleave(q);
        // print the queue
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
     }
}








