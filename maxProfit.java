/*
 * Leetcode 121: Best Time to Buy and Sell Stock 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Martin.Xia
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2||prices==null){
            return 0;
        }else{
            int miniprice=prices[0];
            int minidiff=0;
            for(int i=0;i<prices.length;i++){
                if(prices[i]<miniprice){
                    miniprice=prices[i];
                }
                if(prices[i]-miniprice>minidiff){
                    minidiff=prices[i]-miniprice;
                }
            }
            return minidiff;
        }
    }
}


