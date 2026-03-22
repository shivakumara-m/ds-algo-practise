// Given a string s, find the length of the longest substring without duplicate characters.
// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

package LeetCode_Top_150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithNoRepeatChars3 {

    public static void main(String[] args) {
        LongestSubStringWithNoRepeatChars3 l = new LongestSubStringWithNoRepeatChars3();
        System.out.println(l.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        Map <Character, Integer> charPos = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < s.length()) {
            Character currentChar = s.charAt(right);
            if(charPos.containsKey(currentChar) && charPos.get(currentChar) > left) {
                left = charPos.get(currentChar);
            }
            charPos.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right-left);
            right++;

        }
        return maxLen;
    }
}
