package LeetCode_Top_150.Recursion;
import java.util.Stack;

public class Subsequence {
    public static void main(String[] args) {
        Subsequence s = new Subsequence();
        Stack<Integer> stack = new Stack<>();
        s.generateSubsequence(0, stack, new int[] {3,2,1,3});
    }

    public void generateSubsequence(int idx, Stack<Integer> stack, int[] originalArray){
        if(idx == originalArray.length) {
            System.out.println(stack.toString());
            return;
        }
        stack.add(originalArray[idx]);
        generateSubsequence(idx+1, stack, originalArray);
        stack.pop();
        generateSubsequence(idx+1, stack, originalArray);

    }
}
