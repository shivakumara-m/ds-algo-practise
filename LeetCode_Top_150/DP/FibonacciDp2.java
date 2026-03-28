package LeetCode_Top_150.DP;

public class FibonacciDp2 {
    public static void main(String[] args) {
        FibonacciDp2 fibonacciDp2 = new FibonacciDp2();
        System.out.println(fibonacciDp2.fib(12));
    }

    public int fib(int n) {

        int prev1 = 1;
        int prev2 = 0;
        int cur=-1;
        for (int i = 2; i < n; i++) {
           cur = prev1 + prev2;
           prev2 = prev1;
           prev1 = cur;
        }
        return cur;
    }

}
