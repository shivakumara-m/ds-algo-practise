/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false
*/


package LeetCode_Top_150.Stack;


import java.util.Stack;

public class Parenthesis_20 {
    public static void main(String[] args) {
        Parenthesis_20 p = new Parenthesis_20();
        System.out.println(p.isValid("()"));
        System.out.println(p.isValid("()[]{}"));
        System.out.println(p.isValid("(]"));

    }

    public boolean isValid(String s) {
        if(s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if(stack.empty()) return false;
                char top = stack.pop();
                if(!isValidPair(c, top)) {
                    return false;
                }

            } else {
                return false;
            }
        }

        return stack.empty();

    }

    private boolean isValidPair(char c, char top) {
        if(c == ')' && top == '(') return true;
        if(c == '}' && top == '{') return true;
        if(c == ']' && top == '[') return true;
        return false;

    }
}
