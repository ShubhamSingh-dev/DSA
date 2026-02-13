public class Q7_MinimumWindowSubstring {


  private static boolean check(int have[] , int need[]){
    for (int i = 0; i < 256 ; i++) {
      if(have[i] < need[i]){
        return false;
      }
    }
    return true;
  }

  // Time Complexity: O(m + (n x 256))
  public String minWindow(String s, String t) {
    int n = s.length();
    int m = t.length();

    if( n < m )
      return "";

    int have[] = new int[256];
    int need[] = new int[256];

    //fill need array 
    for (int i = 0; i < m; i++) {
      char ch = t.charAt(i);
      need[ch]++;
    }

    int low = 0;
    int result = Integer.MAX_VALUE;
    int start = -1;

    // Start of template
    for (int high = 0; high < n ; high++) {

      // add char to have array
      char haveCh = s.charAt(high);
      have[haveCh]++;

      //shrink window -> works only if true
      while (check(have,need)) {
        
        int len = high - low + 1;

        if(result > len){
          result = len;
          start = low;
        }

        char leftCh = s.charAt(low);
        have[leftCh]--;
        low++;
      }
    }

    if(result == Integer.MAX_VALUE)
      return "";
    else
      return s.substring(start, start + result);
  }

  /*
 * NOTE ABOUT THIS APPROACH:
 *
 * This solution is logically correct and produces the right result.
 * However, it is not fully optimized.
 *
 * Problem:
 * The `check(have, need)` function scans all 256 characters
 * every time we try to shrink the window.
 *
 * Even though only one character changes in each step,
 * we still compare the entire frequency array again.
 *
 * This adds unnecessary repeated work and increases time complexity.
 *
 * Improvement:
 * Instead of checking all 256 characters repeatedly,
 * we can maintain a running counter (like `required`)
 * that tracks how many characters are still needed.
 *
 * That way, we avoid the full comparison and achieve true O(n) time complexity.
 *
 * Optimized version is implemented below.
 */


  public static String minWindow_Optimized(String s,String t){

    int m = s.length();
    int n = t.length();

    // Base Case
    if(m < n)
      return "";
    
    int freq[] = new int[256];
    //Filling the frequency array with characters of string t
    for (int i = 0; i < n; i++) {
      char ch = t.charAt(i);
      freq[ch]++;
    }

    int low = 0;
    int minLength = Integer.MAX_VALUE;
    int start = -1;
    int required = t.length(); // Number of charcters in t needed to be in window

    for(int high = 0; high < m; high++){

      char r = s.charAt(high); // right character

      if(freq[r] > 0) 
        required--; // if r is in t, we have one less character to match so required--

      freq[r]--; // reduce frequency of r by 1 as we have seen it once

      //shrink window
      while(required == 0){ //all char of t are in window
        
        int len = high - low + 1;

        if(minLength > len){
          minLength = len;
          start = low; //start is the starting index of substring
        }

        char l = s.charAt(low); //left character
        freq[l]++; //inc freq as we are shrinking we removed the left char and now we donot have it in window

        if(freq[l] > 0) // if l is in t, we have one more character to match so required++
          required++;

        low++; //shrink window
      }
    }


    return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);

  }
}