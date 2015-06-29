/*
 * Leetcode 121: Best Time to Buy and Sell Stock Second Method
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Martin.Xia
 * Second Method
 */
public class Solution {
    public int maxProfit_2(int[] prices) {
        if (prices.length<2||prices==null) return 0;
        int cursum=0;
        int maxsum=0;
        
        for(int i=1;i<prices.length;i++){
            if(cursum<=0){
                cursum=prices[i]-prices[i-1];
            }else{
                cursum=cursum+prices[i]-prices[i-1];
            }
            if(cursum>maxsum){
                maxsum=cursum;
            }
        }
        return maxsum;
    }
}



