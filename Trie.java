/*
 * Leetcode 208: Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Martin.Xia
 */
 //Trie Node
class TrieNode{
    //Or we could use HashSet instead of TrieNode
    public TrieNode[] children = new TrieNode[26];
    //Or we could use a boolean value to save is leaf node or not
    public String item = "";
}
 
//Trie
public class Trie{
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





