import java.util.Stack;

public class Q2_removeAdjacentDuplicates {
  public String removeDuplicates_1(String s) {
    Stack<Character> stack = new Stack<>();
    
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      
      if(!stack.isEmpty() && stack.peek() == ch)
        stack.pop();
      else
        stack.push(ch);
    }
    
    StringBuilder sb = new StringBuilder();
    
    while(!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    return sb.reverse().toString();
  }

  public String removeDuplicates_2(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1); // pop
            } else {
                stack.append(c); // push
            }
        }

        return stack.toString();
    }
}
