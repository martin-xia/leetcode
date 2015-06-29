/*
 * Leetcode 123: Best Time to Buy and Sell Stock III Naive method
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Naive method
 * Martin.Xia
 */
public class Solution {
    public int maxProfit3_1(int[] prices) {
        int twoSum=0;
        for(int i=0;i<prices.length;i++){
            if(twoSum<maxProfitSplit(prices,i)) twoSum=maxProfitSplit(prices,i);
        }
        return twoSum;
    }
    
    public int maxProfitSplit(int[] prices,int i){
        int[] left=Arrays.copyOfRange(prices,0,i);
        int[] right=Arrays.copyOfRange(prices,i,prices.length-1);
        int pricesLeft=maxProfitCompute(left);
        int pricesRight=maxProfitCompute(right);
        
        return Math.max(pricesLeft,pricesRight);
    }
    
    public int maxProfitCompute(int[] prices){
        if(prices.length<2||prices==null) return 0;
        int miniprice = prices[0];
        int maxdiff=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<miniprice) miniprice=prices[i];
            if((prices[i]-miniprice)>maxdiff) maxdiff=prices[i]-miniprice;
        }
        return maxdiff;
    }
}





