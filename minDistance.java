/*
 * Leetcode 72: Edit Distance
 * https://leetcode.com/problems/edit-distance/
 * Martin.Xia
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        int L1 = word1.length();
        int L2 = word2.length();
     
        // L1+1, L2+1, because finally return dp[L1][L2]
        int[][] dp = new int[L1 + 1][L2 + 1];
     
        for (int i = 0; i <= L1; i++) {
            dp[i][0] = i;
        }
     
        for (int j = 0; j <= L2; j++) {
            dp[0][j] = j;
        }
     
        //iterate though, and check last char
        for (int i = 0; i < L1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < L2; j++) {
                char c2 = word2.charAt(j);
     
                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
     
                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
     
        return dp[L1][L2];
    }
}