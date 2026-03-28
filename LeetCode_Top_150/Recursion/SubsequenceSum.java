package LeetCode_Top_150.Recursion;
import java.util.Stack;

public class SubsequenceSum {
    static boolean flag = false;
    public static void main(String[] args) {
        SubsequenceSum s = new SubsequenceSum();
        Stack<Integer> stack = new Stack<>();
        int targerSumt = 5;
        s.generateSubsequence(0, stack, new int[] {3,2,1, 3}, targerSumt, 0);

    }

    public void generateSubsequence(int idx, Stack<Integer> stack, int[] originalArray, int targetSum, int actaulSum){
        if(SubsequenceSum.flag) return;
        if(idx == originalArray.length) {
            if(targetSum == actaulSum) {
                System.out.println(stack.toString());
                SubsequenceSum.flag = true;
            }
            return;
        }
        stack.add(originalArray[idx]);
        actaulSum += originalArray[idx];
        generateSubsequence(idx+1, stack, originalArray, targetSum, actaulSum);
        int popNum = stack.pop();
        actaulSum -= popNum;
        generateSubsequence(idx+1, stack, originalArray, targetSum, actaulSum);

    }
}
