/*
 * Leetcode 99: Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Method with O(1) space, Morris Algorithm
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
     private void swap(TreeNode first, TreeNode second) {
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp; 
        }
        return;
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode parent = null;
        TreeNode first = null;
        TreeNode second = null;
        boolean found = false;
        
        while(cur != null) {
            if(cur.left == null) {
                if(parent!=null && parent.val > cur.val) {
                    if(!found) {
                        first = parent;
                        found = true;
                    }
                    second = cur;
                }
                parent = cur;
                cur = cur.right;
            }
            else {
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    pre.right = null;
                    
                    if(parent.val > cur.val) {
                        if(!found) {
                            first = parent;       
                            found = true;
                        }
                        second = cur;
                    }
                    parent = cur;
                    cur = cur.right;
                }
            }
        }
        
        swap(first,second);
    }
}