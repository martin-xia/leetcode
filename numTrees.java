/*
 * Leetcode 96: Unique Binary Search Trees Naive method
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Naive method
 * Martin.Xia
 */
 public class Solution {
    public int numTrees(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
}






