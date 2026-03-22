
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/


public class StringPalindrome125 {

    public static void main(String[] args) {
        PalindromeChecker sChecker = new PalindromeChecker();

        System.out.println("is Palindrome " + sChecker.IsPalindrome("sA man, a plan, a canal: Panama"));

    }

}

class PalindromeChecker {
    public boolean IsPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char lChar = Character.toLowerCase(s.charAt(l));
            char rChar = Character.toLowerCase(s.charAt(r));

            if (!Character.isLetterOrDigit(rChar)) {
                r--;
                continue;
            }

            if (!Character.isLetterOrDigit(lChar)) {
                l++;
                continue;
            }

            if (lChar != rChar) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}