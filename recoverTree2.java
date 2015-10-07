/*
 * Leetcode 99: Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Method with O(log n) space
 * Martin.Xia
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode pre;
    TreeNode first;
    TreeNode second;
      
    private void inorder(TreeNode root){  
        if(root == null)  
            return;  

        inorder(root.left);  
        if(pre == null){  
            pre = root;  
        }else{  
            if(pre.val > root.val){  
                if(first == null){  
                    first = pre;
                }  
                second = root;  
            }  
            pre = root;  
        }  
        inorder(root.right);  
    }  
    
    private void swap(TreeNode first, TreeNode second) {
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp; 
        }
        return;
    }
      
    public void recoverTree(TreeNode root) {  
        pre = null;  
        first = null;  
        second = null;  
        inorder(root);  
        swap(first,second);
    }
}