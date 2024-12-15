import java.util.*;

public class L7_FirstNonRepeating {
    // Method to print the first non-repeating character at every step
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // Array to store frequency of each character ('a' to 'z')
        Queue<Character> q = new LinkedList<>(); // Queue to maintain the order of characters

        // Traverse the input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get the current character

            // Add the character to the queue
            q.add(ch);

            // Increment its frequency in the frequency array
            freq[ch - 'a']++;

            // Remove characters from the queue that have frequency > 1 (are repeating)
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove(); // Remove the front character
            }

            // If the queue is empty, it means there is no non-repeating character
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                // Otherwise, the front of the queue is the first non-repeating character
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println(); // Print a new line after the output
    }

    public static void main(String[] args) {
        // Example input string
        String str = "aabccxb";

        // Call the method to print non-repeating characters at each step
        printNonRepeating(str);
    }
}

