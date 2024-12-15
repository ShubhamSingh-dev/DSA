import java.util.*;

public class L5_QueueUsing2Stacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Check if the queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add element to the queue -> TC = O(n)
        public static void add(int data) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push the new element onto s1
            s1.push(data);

            // Move all elements back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove element from the queue -> TC = O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // Peek the front element of the queue -> TC = O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        // Print and remove elements from the queue
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
