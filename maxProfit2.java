/*
 * Leetcode 122: Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Martin.Xia
 */
 public class Solution {
    public int maxProfit2(int[] prices) {
        if(prices.length<2||prices==null){
            return 0;
        }
        int sum=0;
        int maxsum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                maxsum=maxsum+prices[i]-prices[i-1];
            }
        }
        return maxsum;
    }
}




