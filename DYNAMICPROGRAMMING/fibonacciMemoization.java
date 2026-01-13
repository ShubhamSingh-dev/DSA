public class fibonacciMemoization {

  // Time Complexity: O(n)
  public static int fib(int n, int[] memo) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (memo[n] != 0) { //fib(n) is already calculated
      return memo[n];
    }

    memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    return memo[n];
  }
  public static void main(String[] args) {
    int n = 10;

    int[] memo = new int[n + 1]; // memo[i] stores the value of fib(i)

    System.out.println(fib(n, memo));
  }
}