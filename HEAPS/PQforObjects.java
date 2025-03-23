import java.util.PriorityQueue;

public class PQforObjects {
  // Student class to represent a student with a name and rank
  static class Student implements Comparable<Student> {
    String name; // Name of the student
    int rank; // Rank of the student

    // Constructor to initialize the student's name and rank
    public Student(String name, int rank) {
      this.name = name;
      this.rank = rank;
    }

    // Overriding the compareTo method to define the natural ordering of Student objects
    @Override
    public int compareTo(Student s2) {
      // Compare students based on their rank
      // A lower rank means higher priority in the priority queue
      return this.rank - s2.rank; // Ascending order based on rank
    }
  }

  public static void main(String[] args) {
    // PriorityQueue to store Student objects
    // The priority queue will use the compareTo method of the Student class to order the elements
    PriorityQueue<Student> pq = new PriorityQueue<>();

    // Adding Student objects to the priority queue
    // The elements will be ordered based on their rank (ascending order)
    pq.add(new Student("A", 4)); // Student A with rank 4
    pq.add(new Student("B", 5)); // Student B with rank 5
    pq.add(new Student("C", 2)); // Student C with rank 2
    pq.add(new Student("D", 12)); // Student D with rank 12

    // Removing and printing elements from the priority queue
    // The elements will be removed in ascending order of rank
    while (!pq.isEmpty()) {
      // Peek at the element with the highest priority (lowest rank)
      System.out.println(pq.peek().name + " -> " + pq.peek().rank);
      // Remove the element with the highest priority
      pq.remove();
    }
    // Output: C -> 2 A -> 4 B -> 5 D -> 12
    // Explanation: The students are printed in ascending order of their rank
  }
}