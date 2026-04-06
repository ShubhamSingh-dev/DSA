import java.util.HashMap;

public class Q4_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for(int count : map.values()){
            if(count % 2 == 0){
                length = length + count;
            } else {
                length = length + count - 1;
                hasOdd = true;
            }
        }

        if(hasOdd) length += 1;

        return length;
    }

    public int longestPalindrome_ASCII(String s) {
        int[] count = new int[128]; // ASCII
        
        // Count frequency
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int c : count) {
            if (c % 2 == 0) {
                length += c;
            } else {
                length += c - 1;
                hasOdd = true;
            }
        }
        
        // Add one odd char in center
        if (hasOdd) length += 1;
        
        return length;
    }
}
