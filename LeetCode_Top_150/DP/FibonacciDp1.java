package LeetCode_Top_150.DP;

public class FibonacciDp1 {
    public static void main(String[] args) {
        FibonacciDp2 fibonacciDp1 = new FibonacciDp2();
        System.out.println(fibonacciDp1.fib(10));
    }

    public int[] fib(int n) {

        int[] dpRes = new int[n];
        dpRes[0]=0;
        dpRes[1]=1;
        for(int i = 2 ; i< n ; i++) {
            dpRes[i]= dpRes[i-1] + dpRes[i-2];
            System.out.println(dpRes[i]);
        }
        return dpRes;
    }

}
