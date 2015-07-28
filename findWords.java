/*
 * Leetcode 212: Word Search II
 * https://leetcode.com/problems/word-search-ii/
 * Martin.Xia
 */
public class Solution {
    Set<String> result = new HashSet<String>(); 
 
    public List<String> findWords(char[][] board, String[] words) {
        //HashSet<String> result = new HashSet<String>();
 
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
 
        int m=board.length;
        int n=board[0].length;
 
        boolean[][] recordVisited = new boolean[m][n];
 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               wordSearch(board, recordVisited, "", i, j, trie);
            }
        }
 
        return new ArrayList<String>(result);
    }
 
    public boolean wordSearch(char[][] board, boolean[][] recordVisited, String str, int i, int j, Trie trie){
        int m=board.length;
        int n=board[0].length;
 
        if(i<0 || j<0||i>=m||j>=n){
            return false;
        }
 
        if(recordVisited[i][j])
            return false;
 
        str = str + board[i][j];
 
        if(!trie.startsWith(str))
            return false;
 
        if(trie.search(str)){
            result.add(str);
        }
 
        recordVisited[i][j]=true;
        boolean res = wordSearch(board, recordVisited, str, i-1, j, trie)  
                 || wordSearch(board, recordVisited, str, i+1, j, trie)   
                 || wordSearch(board, recordVisited, str, i, j+1, trie) 
                 || wordSearch(board, recordVisited, str, i, j-1, trie);   
         recordVisited[i][j] = false;  
         return res; 
    }
}

class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
}
 
//Trie
class Trie{
    public TrieNode root = new TrieNode();
 
    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }
 
    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.item.equals(word)){
            return true;
        }else{
            return false;
        }
    }
 
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}





