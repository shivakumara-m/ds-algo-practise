
import java.util.HashMap;

public class LongestNonRepeatSubStr {

    public static void main(String args[]) {
        char[] arr = {'a', 'b', 'a', 'c', 'a', 'd', 'd', 'f'};
        HashMap<Character, Integer> map = new HashMap<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int maxLen = 0;

        while (leftPtr <= rightPtr && rightPtr < arr.length) {
            if (!map.containsKey(arr[rightPtr])) {
                rightPtr++;
                map.put(arr[leftPtr], leftPtr);
                maxLen = Math.max(maxLen, rightPtr - leftPtr + 1);
            } else {
                if (leftPtr >= map.get(arr[rightPtr])) {
                    leftPtr++;

                }
            }

        }
    System.err.println("maxLen = " + maxLen);

    }

}

