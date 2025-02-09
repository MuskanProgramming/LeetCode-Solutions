/**
 * Count Number of Bad Pairs
 *
 * Problem Statement:
 * - Given a 0-indexed integer array nums.
 * - A pair (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
 * - Return the total number of bad pairs in nums.
 *
 * Example 1:
 *   Input: nums = [4,1,3,3]
 *   Output: 5
 *   Explanation:
 *   The bad pairs are: (0,1), (0,2), (0,3), (1,2), (2,3).
 *
 * Example 2:
 *   Input: nums = [1,2,3,4,5]
 *   Output: 0
 *   Explanation: There are no bad pairs.
 *
 * Approach: HashMap Optimization (O(n) Time, O(n) Space)
 * - Use a HashMap to store occurrences of nums[j] - j.
 * - Compute total pairs as n * (n - 1) / 2.
 * - Count good pairs and subtract from total pairs.
 */

 import java.util.*;

 public class CountBadPairs {
     public static long countBadPairs(int[] nums) {
         Map<Integer, Integer> freqMap = new HashMap<>();
         long totalPairs = (long) nums.length * (nums.length - 1) / 2;
         long goodPairs = 0;
         
         for (int j = 0; j < nums.length; j++) {
             int diff = nums[j] - j;
             goodPairs += freqMap.getOrDefault(diff, 0);
             freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
         }
         
         return totalPairs - goodPairs;
     }
 
     public static void main(String[] args) {
         int[] nums1 = {4,1,3,3};
         System.out.println(countBadPairs(nums1)); // Output: 5
         
         int[] nums2 = {1,2,3,4,5};
         System.out.println(countBadPairs(nums2)); // Output: 0
     }
 }
 