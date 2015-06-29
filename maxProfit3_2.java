/*
 * Leetcode 123: Best Time to Buy and Sell Stock III 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Martin.Xia
 */
public class Solution {
    public int maxProfit3_2(int[] prices) {
        if(prices.length<2||prices==null) return 0;
        int miniprice=prices[0];
        int maxdiff=0;
        int[] maxProfitFromHead = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            if (miniprice>prices[i]) miniprice=prices[i];
            if ((prices[i]-miniprice)>maxdiff) maxdiff=prices[i]-miniprice;
            maxProfitFromHead[i]=maxdiff;
        }
        
        int maxprice=prices[prices.length-1];
        int res=maxProfitFromHead[prices.length-1];
        int maxdifff=0;
        for(int i=prices.length-1;i>=0;i--){
            if(maxprice<prices[i]) maxprice=prices[i];
            if((maxprice-prices[i])>maxdifff) maxdifff=maxprice-prices[i];
            
            if((maxdifff+maxProfitFromHead[i])>res) res=maxdifff+maxProfitFromHead[i];
        }
        
        return res;
    }
}





