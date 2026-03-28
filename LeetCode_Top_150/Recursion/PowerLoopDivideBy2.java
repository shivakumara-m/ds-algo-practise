package LeetCode_Top_150.Recursion;

public class PowerLoopDivideBy2 {
    public static void main(String[] args) {
        PowerLoopDivideBy2 power = new PowerLoopDivideBy2();
        System.out.println(power.myPow(2, 10));
    }

    public double myPow(double x, int n) {
        if (x == 0)
            return 1;
        if (x < 0)
            return 1 / myPow(Math.abs(x), n);
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
                n = n - 1;
            } else {
                res = x * x;
                n = n / 2;
            }

        }
        return res;
    }
}
