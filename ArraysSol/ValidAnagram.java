/*
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Approach 1: Sorting - O(n log n)
 * Sort both strings and check if they are equal.
 *
 * Approach 2: HashMap Frequency Count - O(n)
 * Use a HashMap to store the frequency of characters and compare.
 */

 import java.util.Arrays;
 import java.util.HashMap;
 
 public class ValidAnagram {
 
     // Approach 1: Sorting (O(n log n))
     public static boolean isAnagramSorting(String s, String t) {
         if (s.length() != t.length()) return false;
         
         char[] sArr = s.toCharArray();
         char[] tArr = t.toCharArray();
         Arrays.sort(sArr);
         Arrays.sort(tArr);
         
         return Arrays.equals(sArr, tArr);
     }
 
     // Approach 2: HashMap Frequency Count (O(n))
     public static boolean isAnagramHashMap(String s, String t) {
         if (s.length() != t.length()) return false;
 
         HashMap<Character, Integer> freq = new HashMap<>();
 
         // Count characters in string s
         for (char ch : s.toCharArray()) {
             freq.put(ch, freq.getOrDefault(ch, 0) + 1);
         }
 
         // Decrease count for string t
         for (char ch : t.toCharArray()) {
             if (!freq.containsKey(ch) || freq.get(ch) == 0) {
                 return false;
             }
             freq.put(ch, freq.get(ch) - 1);
         }
 
         return true;
     }
 
     public static void main(String[] args) {
         String s1 = "anagram", t1 = "nagaram";
         String s2 = "rat", t2 = "car";
 
         System.out.println("Sorting Approach:");
         System.out.println("Is Anagram? " + isAnagramSorting(s1, t1)); // true
         System.out.println("Is Anagram? " + isAnagramSorting(s2, t2)); // false
         System.out.print("------------------------------------------------");
         System.out.println("\nHashMap Approach:");
         System.out.println("Is Anagram? " + isAnagramHashMap(s1, t1)); // true
         System.out.println("Is Anagram? " + isAnagramHashMap(s2, t2)); // false
     }
 }
 