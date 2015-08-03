/*
 * Leetcode 59: Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Martin.Xia
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<=0){
            return new int[0][0];
        }
        int [][] matrix=new int[n][n];
        int total = n*n;
        int beginX=0;
        int endX=n-1;
        
        int beginY=0;
        int endY=n-1;
        int current=1;
        
        while (current<=total){
            for (int col=beginX; col<=endX; col++){
                
                matrix[beginY][col]=current++;
            }
            beginY++;
            for (int row=beginY; row<=endY; row++){
                matrix[row][endX]=current++;
            }
            endX--;
            
            for (int col=endX; col>=beginX; col--){
                matrix[endY][col]=current++;
            }
            endY--;
            
            for (int row=endY; row>=beginY; row--){
                matrix[row][beginX]=current++;
            }
            beginX++;
        }
                       
        return matrix;
    }
}





