public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] firstHalf = new int[prices.length];
        int[] secondHalf = new int[prices.length];
        int current = 0;
        int max = 0;
        //calculate the max profit from day 1 to day i
        for(int i = 1; i < prices.length; i++){
            current = Math.max(0,current + prices[i] - prices[i-1]);
            max = Math.max(current, max);
            firstHalf[i] = max;
        }
        //calculate the max profit from day i to day n, where n is the last day
        current = 0;
        max = 0;
        for(int i = prices.length - 1; i >0; i--){
            current = Math.max(0,current + prices[i] - prices[i-1]);
            max = Math.max(current, max);
            secondHalf[i-1] = max;
        }        
        //find the max at each split, we have the result!
        max = 0;
        for(int i = 0; i < prices.length; i++){
            max = Math.max(firstHalf[i]+secondHalf[i], max);
        }
        return max;
    }