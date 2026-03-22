// package LeetCode_Top_150;

// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
public class LengthofLastWord58 {
    public static void main(String[] args) {
        LengthofLastWord58 l = new LengthofLastWord58();
        System.out.println(l.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        if(s.length() < 1 ) return 0;
        boolean isFirstCharFound  = false;
        int len = 0;
        for (int i = s.length()-1;  i>= 0; i-- ){
            char c = s.charAt(i);
            if(c == ' ' && !isFirstCharFound) {
                continue;
            }
            if(c == ' ' && isFirstCharFound) {
                break;
            }
            isFirstCharFound = true;
            len++;
        }
        return len;
    }
}
