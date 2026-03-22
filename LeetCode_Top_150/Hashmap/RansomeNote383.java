/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
*/


package LeetCode_Top_150.Hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RansomeNote383 {
    public static void main(String[] args) {
        RansomeNote383 ransomeNote383 = new RansomeNote383();
        System.out.println(ransomeNote383.canConstruct("a", "aaa"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteCharacters = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int charCount = 1;
            if (noteCharacters.containsKey(c)) {
                charCount = noteCharacters.get(c);
                charCount++;
            }
            noteCharacters.put(c, charCount);
        }

        System.out.print(noteCharacters);
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(noteCharacters.containsKey(c)) {
                int charCount = noteCharacters.get(c);
                charCount--;
                noteCharacters.put(c, charCount);
            }
        }

        Set<Character> s = noteCharacters.keySet();
        boolean canConstruct = true;
        Iterator<Character> itr = s.iterator();
        while (itr.hasNext()) {
            char c = itr.next();
            boolean isCountZero = noteCharacters.get(c) < 0;
            canConstruct = canConstruct && isCountZero;
        }
        return canConstruct;
    }
}