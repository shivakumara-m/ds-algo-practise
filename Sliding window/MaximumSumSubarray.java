import java.util.Arrays;

public class MaximumSumSubarray {
  public static void main(String args[]) {
   int[] arr = { 10, 2, 3, -10, 10, 20, 1, 4 };
   int windowSize = 3;
   int leftPtr = 0;
   int rightPtr = windowSize;
    int maxSum = 0;
    int leftPos = leftPtr;
    int rightPos = rightPtr;
    for (int i=0; i<windowSize; i++) {
        maxSum+= arr[i];
    }
    int prevWindowSum = maxSum;
    System.out.println("Array = " + Arrays.toString(arr));
    System.out.println("Max sum init = " + maxSum);
    while(rightPtr < arr.length) {
        int itemToRemove = arr[leftPtr];
        int itemToAdd = arr[rightPtr];
         int nextWindowSum = 0;
        if(itemToRemove > 0){
           nextWindowSum = prevWindowSum - itemToRemove + itemToAdd;
        } else {
            nextWindowSum = prevWindowSum + itemToRemove + itemToAdd;
        }
        System.out.println("nextWindowSum = " + nextWindowSum + " leftPtr = " + leftPtr + " rightPtr = " + (rightPtr));
        if (nextWindowSum > maxSum) {
            maxSum = nextWindowSum;
            leftPos = leftPtr+2;
            rightPos = rightPtr+1;
        }
        rightPtr++;
        leftPtr++;
        prevWindowSum = nextWindowSum;
    }
      System.out.println("sum = " + maxSum + " leftPos = " + leftPos + " rightPos = " + rightPos);
  }
}