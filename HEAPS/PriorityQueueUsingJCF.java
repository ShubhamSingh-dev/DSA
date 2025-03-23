import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueUsingJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(/*Comparator.reverseOrder()*/); 
        //Comparator.reverseOrder() is used to reverse the order of the elements in the priority queue. By default, it is a min heap ie in Ascending Order. 

        pq.add(3); //O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); //O(1)
            pq.remove();//O(logn)
          
        }
    }
    
}

// Output: 1 3 4 7 
// Why ? Because the priority queue is implemented using a min heap. So, the smallest element is always at the root.