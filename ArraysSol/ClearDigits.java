/*
 * Problem Statement:
 * You are given a string s. Your task is to remove all digits by performing the following operation repeatedly:
 * - Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: "abc"
 * Explanation: There is no digit in the string.
 *
 * Example 2:
 * Input: s = "cb34"
 * Output: ""
 * Explanation:
 * First, remove '3' and the closest left character 'b', resulting in "c4".
 * Then, remove '4' and the closest left character 'c', resulting in "".
 *
 * Approach: Stack-based Solution - O(n)
 * - Use a StringBuilder as a stack.
 * - Traverse the string, if a digit is found, remove the last character from the stack.
 * - If not a digit, push it onto the stack.
 * - Return the final string from the stack.
 */

 public class ClearDigits {
    public static String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1); // Remove closest left non-digit
                }
            } else {
                stack.append(ch);
            }
        }
        
        return stack.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));  // Output: "abc"
        System.out.println(clearDigits("cb34")); // Output: ""
        System.out.println(clearDigits("a1b2c3")); // Output: ""
        System.out.println(clearDigits("hello12world34")); // Output: "helorld"
    }
}

