import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> seenChars = new HashMap<>();
        char[] arr = s.toCharArray();
        int arrayLen = arr.length;
        if (arrayLen == 1) {
            return 1;
        }
        for (int right = 0; right < arrayLen; right++) {
            char currentChar = arr[right];
            boolean isAlreadySeen = seenChars.containsKey(currentChar);
            Integer seenPos = seenChars.get(currentChar);
            if (isAlreadySeen && seenPos != null && seenPos >= left) { // this is critical check
                left = seenPos + 1;
            } 
            int len = right - left+1;
            maxLen = Math.max(maxLen, len);
            seenChars.put(currentChar, right);
        }

        return maxLen;
    }
}//