/*
 * Problem Statement - Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to the target.
                        Each input has exactly one solution.
                        You cannot use the same element twice.
                        Return the indices in any order.

 * Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 
 * Optimized Using HashMap - O(n) Time, O(n) Space
    Use a HashMap to store numbers and their indices.
    For each number nums[i], check if target - nums[i] exists in the HashMap.
    If yes, return the stored index and current index.
*/

package ArraysSol;

import java.util.HashMap;

public class TwoSumOptimized {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};  // Found the pair
            }

            map.put(nums[i], i);  // Store the current number
        }

        return new int[]{};  // No solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        if (result.length > 0) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution");
        }
    }
}