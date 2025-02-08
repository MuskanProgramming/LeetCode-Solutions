/**
 * Best Time to Buy and Sell Stock
 *
 * Problem Statement:
 * - Given an array prices[] where prices[i] is the stock price on the i-th day.
 * - You must choose one day to buy and one day to sell to maximize profit.
 * - Return the maximum profit possible. If no profit, return 0.
 *
 * Example 1:
 *   Input: prices = [7,1,5,3,6,4]
 *   Output: 5
 *   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 * Approach 1: Brute Force (O(n²) Time, O(1) Space)
 * - Try all possible buy and sell pairs.
 * - Compute profit for every pair and keep track of the maximum profit.
 *
 * Approach 2: Optimized Using Single Pass (O(n) Time, O(1) Space)
 * - Track the minimum price so far while iterating through the array.
 * - Calculate profit each time a new maximum price appears after buying.
 */

 package ArraysSol;

 public class BestTimeToBuyAndSellStock {
 
     // Brute Force Approach - O(n²) Time, O(1) Space
     public static int maxProfitBruteForce(int[] prices) {
         int maxProfit = 0;
         for (int i = 0; i < prices.length; i++) {
             for (int j = i + 1; j < prices.length; j++) {
                 int profit = prices[j] - prices[i];
                 maxProfit = Math.max(maxProfit, profit);
             }
         }
         return maxProfit;
     }
 
     // Optimized Approach - O(n) Time, O(1) Space
     public static int maxProfitOptimized(int[] prices) {
         int minPrice = Integer.MAX_VALUE; // Store the minimum price encountered so far
         int maxProfit = 0; // Store the maximum profit
 
         for (int price : prices) {
             if (price < minPrice) {
                 minPrice = price; // Update the minimum price
             } else {
                 maxProfit = Math.max(maxProfit, price - minPrice); // Update maximum profit
             }
         }
         return maxProfit;
     }
 
     // Main function
     public static void main(String[] args) {
         int[] prices = {7,1,5,3,6,4};
 
         System.out.println("Brute Force Max Profit: " + maxProfitBruteForce(prices));
         System.out.println("Optimized Max Profit: " + maxProfitOptimized(prices));
     }
 }
 