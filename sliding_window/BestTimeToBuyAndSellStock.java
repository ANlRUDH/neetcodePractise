/*
LeetCode 121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No transaction is done, i.e. max profit = 0.
*/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }

    // Helper method to print an array
    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.print("Input: prices = ");
        solution.printArray(prices1);
        int result1 = solution.maxProfit(prices1);
        System.out.println("Output: " + result1); // Expected: 5
        
        // Test case 2: No profit possible
        System.out.println("\nTest case 2:");
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.print("Input: prices = ");
        solution.printArray(prices2);
        int result2 = solution.maxProfit(prices2);
        System.out.println("Output: " + result2); // Expected: 0
        
        // Test case 3: Single day
        System.out.println("\nTest case 3:");
        int[] prices3 = {1};
        System.out.print("Input: prices = ");
        solution.printArray(prices3);
        int result3 = solution.maxProfit(prices3);
        System.out.println("Output: " + result3); // Expected: 0
        
        // Test case 4: Two days
        System.out.println("\nTest case 4:");
        int[] prices4 = {1, 2};
        System.out.print("Input: prices = ");
        solution.printArray(prices4);
        int result4 = solution.maxProfit(prices4);
        System.out.println("Output: " + result4); // Expected: 1
        
        // Test case 5: Multiple peaks
        System.out.println("\nTest case 5:");
        int[] prices5 = {3, 2, 6, 5, 0, 3};
        System.out.print("Input: prices = ");
        solution.printArray(prices5);
        int result5 = solution.maxProfit(prices5);
        System.out.println("Output: " + result5); // Expected: 4
    }
}

/*
Explanation:
We keep track of the minimum price seen so far and the maximum profit. For each price, update the minimum or calculate the profit if sold today.
*/ 