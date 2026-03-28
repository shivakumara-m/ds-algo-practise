package LeetCode_Top_150.DP;

public class ClimbingStairWithCostRecusrion {
    public static void main(String[] args) {
        ClimbingStairWithCostRecusrion c = new ClimbingStairWithCostRecusrion();
        int[] arr = new int[] { 30, 20, 50, 10, 40 };
        int n = arr.length;
        System.out.println(c.minCost(arr, n - 1));

        arr = new int[] { 20, 30, 40, 20 };
        n = arr.length;
        System.out.println(c.minCost(arr, n - 1));
    }

    int minCost(int[] costArray, int n) {

        if (n == 1) {
            int cost = Math.abs(costArray[1] - costArray[0]);
            return cost;
        }
        if (n == 0) {
            return 0;
        }

        int n1Cost = Math.abs(costArray[n] - costArray[n - 1]);
        int n2Cost = Math.abs(costArray[n] - costArray[n - 2]);

        return Math.min(minCost(costArray, n - 1) + n1Cost, minCost(costArray, n - 2) + n2Cost);
    }
}
