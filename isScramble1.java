/*
 * Leetcode 87: Scramble String
 * Dynamic programming method
 * https://leetcode.com/problems/scramble-string/
 * Martin.Xia
 */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        //Check lengths.
        if (s1==null || s2==null || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
            
        int L = s1.length();
        // scramble[i][j][k]=true means: s1.substring(i,i+k) and s2.substring(j,j+k) is scramble
        // Thus scramble[i][j][0] has no meaning, k start from 1
        boolean[][][] scramble = new boolean[L][L][L+1];
        // Initiate scramble[][][], note that in Java boolean's default value is false
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++)
                if (s1.charAt(i) == s2.charAt(j))
                    scramble[i][j][1] = true;
        }
        
        for (int len = 2; len <= L; len++) {
            for (int i = 0;i < L - len + 1; i++) {
                for(int j = 0; j < L - len + 1; j++) {
                    for(int k = 1; k < len; k++) {
                        scramble[i][j][len] |= (scramble[i][j][k]&&scramble[i+k][j+k][len-k] || scramble[i][j+len-k][k]&&scramble[i+k][j][len-k]);
                    }
                }
            }
        }
        return scramble[0][0][L];
    }
}