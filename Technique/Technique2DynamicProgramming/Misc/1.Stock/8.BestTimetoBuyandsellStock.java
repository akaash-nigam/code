 */
public class MaxProfit {    
    
    // Best Time to Buy and Sell Stock III
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; 
        }
        
        int[] left = new int[prices.length]; // left[i] means highest profit in (0..i) 
        int[] right = new int[prices.length];

        // DP from left to right
        left[0] = 0; // DP initial state
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min); 
        }
        
        // DP from right to left
        right[prices.length - 1] = 0;  // DP initial state
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
    
    
    // Best Time to Buy and Sell Stock I
    /**
     * Solution: Find the increasing pair(lowest, highest), Only need to record lowest prices, and profit.
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; 
        }
        
        int lowest = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int currentPrice : prices) {
            lowest = Math.min(lowest, currentPrice);
            profit = Math.max(profit, currentPrice - lowest);
        }
        
        return profit;
    }
    
    // Best Time to Buy and Sell Stock II
    /**
     * Solution: Add all increasing pairs. 
     * 
     * Myway: 5 7 9 3 6 4  (5,9) (3,6)  only prices[i+1] < prices[i] add profit to result; but it's meaningless.
     * just add (5,7) (7,9) (3,6) make it easy
     * 
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0; 
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int signleProfit = prices[i + 1] - prices[i];
            if (signleProfit > 0) {
                profit += signleProfit;
            }
        }
        
        return profit;
    }
    
    // Stock I : Brute Force O(n^2) Time Limit Exceeded -- Wrong. sale at highest first, and buy at lowest are not accepted.
    // Arrays.sort(prices). return prices[length - 1] - prices[0] also doesn't work.
    // My mistake: (highest, lowest) doesn't mean profit!
    public int maxProfitWrongWay(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                result = Math.max(result, Math.abs(prices[i] - prices[j]));
            }
        }
        
        return result;
    }
}