/*
 * Leetcode 79: Word Search
 * https://leetcode.com/problems/word-search/
 * Martin.Xia
 */
 public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;  
        int n = board[0].length;  
        boolean[][] recordVisited = new boolean[m][n];  
          for (int i = 0; i < m; i++) {  
              for (int j = 0; j < n; j++) {  
                  if (wordSearch(board,recordVisited, word, 0, i, j))  
                      return true;  
              }  
         }  
         return false;  
    }
    
    public boolean wordSearch(char[][] board, boolean[][] recordVisited, String word, int visitedLength, int rowIndex, int colIndex) {  
         if (visitedLength == word.length())  
             return true;  
         if (rowIndex < 0 || colIndex < 0 || rowIndex >=board.length || colIndex >= board[0].length)  
             return false;  
         if (recordVisited[rowIndex][colIndex])  
             return false;  
         if (board[rowIndex][colIndex] != word.charAt(visitedLength))  
             return false;  
         recordVisited[rowIndex][colIndex] = true;  
         boolean res = wordSearch(board, recordVisited, word, visitedLength + 1, rowIndex - 1, colIndex)  
                 || wordSearch(board, recordVisited, word, visitedLength + 1, rowIndex + 1, colIndex)  
                 || wordSearch(board, recordVisited, word, visitedLength + 1, rowIndex, colIndex + 1)  
                 || wordSearch(board, recordVisited, word, visitedLength + 1, rowIndex, colIndex - 1);  
         recordVisited[rowIndex][colIndex] = false;  
         return res;  
    }
}





