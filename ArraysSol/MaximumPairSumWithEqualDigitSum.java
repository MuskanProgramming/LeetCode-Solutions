/**
 * Problem Statement:
 * You are given a 0-indexed array nums consisting of positive integers.
 * You can choose two indices i and j, such that i != j, and the sum of digits of nums[i] is equal to that of nums[j].
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 *
 * Example 1:
 * Input: nums = [18, 43, 36, 13, 7]
 * Output: 54
 * Explanation: The pair (18, 36) has the same digit sum (1+8 = 3+6 = 9), and 18 + 36 = 54.
 *
 * Example 2:
 * Input: nums = [10, 12, 19, 14]
 * Output: -1
 * Explanation: No two numbers have the same digit sum, so return -1.
 *
 * Approach:
 * - Use a HashMap to store the maximum number for each digit sum.
 * - Iterate through the array, compute the digit sum for each number.
 * - If another number with the same digit sum exists, calculate the sum and update the maximum.
 * - Update the HashMap with the maximum number for each digit sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;

public class MaximumPairSumWithEqualDigitSum {
     // Function to compute sum of digits of a number
     static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;  // Extract last digit and add to sum
            num /= 10;        // Remove last digit
        }
        return sum;
    }

    public static int maxPairSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int sum = digitSum(num);

            if (map.containsKey(sum)) {
                maxSum = Math.max(maxSum, map.get(sum) + num);
                map.put(sum, Math.max(map.get(sum), num)); // Keep the larger value for this digit sum
            } else {
                map.put(sum, num);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {18, 43, 36, 13, 7};
        System.out.println("Output: " + maxPairSum(nums1));  // Expected: 54

        int[] nums2 = {10, 12, 19, 14};
        System.out.println("Output: " + maxPairSum(nums2));  // Expected: -1
    }
}
