public class L1_Queue_Java {
  static class Queue {
    static int arr[]; //create an array
    static int size;
    static int rear;

    //queue constructor
    Queue(int n) {//n is the size of the array
      arr = new int[n];
      size = n;
      rear = -1;
    }

    // function to check if the queue is empty
    public static boolean isEmpty() {
      return rear == -1;
    }

    //Add element to the queue
    public static void add(int data) {
      //check if the queue is full
      if (rear == size-1) { 
        System.out.println("Queue is full");
        return;
      }

      rear = rear + 1;
      arr[rear] = data;
    }

    // Remove element from the queue
    public static int remove() {
      if(isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }

      //store the front element
      int front = arr[0];
      for(int i = 0; i < rear; i++) {
        arr[i] = arr[i+1];
      }
      //decrement the rear
      rear = rear - 1;
      return front;
    }

    //peek function
    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }

      return arr[0];
    }
  }

  public static void main(String[] args) {
    Queue q = new Queue(5);

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}