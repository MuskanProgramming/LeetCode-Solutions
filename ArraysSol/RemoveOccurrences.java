/*
 * Problem Statement - Given a string s and a substring part, remove all occurrences 
 * of part from s until none remain.
 * A substring is a contiguous sequence of characters in a string.
 *
 * Example 1:
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations occur:
 * - Remove "abc" at index 2: "dabaabcbc"
 * - Remove "abc" at index 4: "dababc"
 * - Remove "abc" at index 3: "dab"
 *
 * Brute Force Approach - O(n * m) Time, O(1) Space
 * - Use the `indexOf()` method to find the leftmost occurrence of part in s.
 * - Remove it using substring operations.
 * - Repeat until part is no longer found.
 * 
 * 
 * Optimized Approach - O(n) Time, O(n) Space
 * - Use a StringBuilder to store the modified string.
 * - Append characters one by one, checking if the last characters match part.
 * - If found, remove part from StringBuilder.
 */

 public class RemoveOccurrences {
    public static String removeOccurrencesBruteForce(String s, String part) {
        while (s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }

    public static String removeOccurrencesOptimized(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int partLength = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length() >= partLength && sb.substring(sb.length() - partLength).equals(part)) {
                sb.delete(sb.length() - partLength, sb.length());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "daabcbaabcbc", part1 = "abc";
        String s2 = "axxxxyyyyb", part2 = "xy";

        System.out.println("Brute Force Approach:");
        System.out.println(removeOccurrencesBruteForce(s1, part1)); // Output: "dab"
        System.out.println(removeOccurrencesBruteForce(s2, part2)); // Output: "ab"

        System.out.println("Optimized Approach:");
        System.out.println(removeOccurrencesOptimized(s1, part1)); // Output: "dab"
        System.out.println(removeOccurrencesOptimized(s2, part2)); // Output: "ab"
    }
}
