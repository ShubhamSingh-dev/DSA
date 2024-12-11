public class L2_CircularQueue {
  static class Queue {
    static int arr[]; //create an array
    static int size;
    static int rear;
    static int front;

    //queue constructor
    Queue(int n) {//n is the size of the array
      arr = new int[n];
      size = n;
      rear = -1;
      front = -1;
    }

    // function to check if the queue is empty
    public static boolean isEmpty() {
      return rear == -1 && front == -1;
    }

    public static boolean isFull() {
      return (rear + 1) % size == front;
    }

    //Add element to the queue
    public static void add(int data) { //TC = O(1)
      //check if the queue is full
      if (isFull()) { 
        System.out.println("Queue is full");
        return;
      }
      
      //when add 1st element
      if(front == -1) {
        front = 0;
      }

      rear = (rear + 1) % size;
      arr[rear] = data;
    }

    // Remove element from the queue
    public static int remove() { //TC = O(1)
      if(isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }

      int result = arr[front];

      //last el delete
      if (front == rear) {
        rear = front = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    //peek function
    public static int peek() { //TC = O(1)
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }

      return arr[front];
    }
  }

  public static void main(String[] args) {
    Queue q = new Queue(5);

    q.add(1);
    q.add(2);
    q.add(3);
    System.out.println(q.remove());
    q.add(4);
    System.out.println(q.remove());
    q.add(5);
    

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}