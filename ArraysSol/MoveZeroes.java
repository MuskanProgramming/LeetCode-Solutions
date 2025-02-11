/*
 * Problem Statement - Given an integer array nums, move all 0's to the end while maintaining 
 * the relative order of the non-zero elements.
 * You must do this in-place without making a copy of the array.
 *
 * Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
  
 * Brute Force Approach - O(n²) Time, O(1) Space
    Iterate through the array and for every zero found, shift all elements left.

 * Optimized Approach - O(n) Time, O(1) Space
    Use two pointers to efficiently move non-zero elements forward.
*/

public class MoveZeroes {
    public static void moveZeroesBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != 0) {
                        // Swap non-zero element with zero
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void moveZeroesOptimized(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Brute Force Approach:");
        moveZeroesBruteForce(nums);
        printArray(nums);

        int[] numsOptimized = {0, 1, 0, 3, 12};
        System.out.println("Optimized Approach:");
        moveZeroesOptimized(numsOptimized);
        printArray(numsOptimized);
    }
}
