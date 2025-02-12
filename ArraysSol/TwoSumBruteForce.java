/*
 * Problem Statement - Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to the target.
                        Each input has exactly one solution.
                        You cannot use the same element twice.
                        Return the indices in any order.

 * Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 
 * Brute Force Solution - O(n²) Time, O(1) Space
    Use two loops to check every pair (i, j).
    If nums[i] + nums[j] == target, return indices [i, j]    
*/

public class TwoSumBruteForce {
    public static int[] twoSum(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
            
            for (int j = i + 1; j < nums.length; j++) {
            
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};  // Found the pair
                }
            }
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
