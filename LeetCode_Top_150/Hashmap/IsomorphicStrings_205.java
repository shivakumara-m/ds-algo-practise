package LeetCode_Top_150.Hashmap;

// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// Example 2:

// Input: s = "f11", t = "b23"

// Output: false

// Explanation:

// The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

// Example 3:

// Input: s = "paper", t = "title"

// Output: true
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
    public static void main(String[] args) {
        IsomorphicStrings_205 is = new IsomorphicStrings_205();
        System.out.println(is.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sToTMap.containsKey(sChar) && sToTMap.get(sChar) != tChar) {
                return false;
            }
            if(tToSMap.containsKey(tChar) && tToSMap.get(tChar) != sChar) {
                return false;
            }

            sToTMap.put(sChar, tChar);
            tToSMap.put(tChar, sChar);
        }
        return true;
    }

}
