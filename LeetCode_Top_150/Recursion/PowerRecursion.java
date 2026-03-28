package LeetCode_Top_150.Recursion;

public class PowerRecursion {
    public static void main(String[] args) {
        PowerRecursion power = new PowerRecursion();
        System.out.println(power.myPow(2, 200000000));
    }
    public double myPow(double x, int n) {
         if( n ==0 ) return 1;
        if(n<0) {
            return 1/myPow(x, Math.abs(n));
        }
        if(n==1) {
            return x;
        }
        return x* myPow(x, n-1);
    }
}
