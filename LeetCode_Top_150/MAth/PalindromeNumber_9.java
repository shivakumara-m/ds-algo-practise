//Given an integer x, return true if x is a palindrome, and false otherwise.

package LeetCode_Top_150.MAth;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        PalindromeNumber_9 p = new PalindromeNumber_9();
        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(-121));
        System.out.println(p.isPalindrome(10));

    }

    public boolean isPalindrome(int x) {
        int rev = 0;
        int origin = x;
        if(x < 0) return false;
        while (x > 0) {
            rev = (rev * 10) + x % 10;
            x = x / 10;
        }
        return origin == rev;
    }
}
