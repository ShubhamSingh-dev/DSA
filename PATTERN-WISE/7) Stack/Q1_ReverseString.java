import java.util.Stack;

public class Q1_ReverseString{
  public void reverse(char[] str){
    Stack<Character> stack = new Stack<>();

    for(int i=0; i < str.length; i++){
      stack.push(str[i]); //pushing into the stack
    }

    for(int i=0; i < str.length; i++){
      str[i] = stack.pop(); //popping out from the stack
    }
  }
}