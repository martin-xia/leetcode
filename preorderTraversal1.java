/*
 * Leetcode 144: Binary Tree Preorder Traversal
 * Recursive method
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer> ();
        
        if (root==null){
            return result;    
        }
        builder(root, result);
        return result;
    }
    private void builder(TreeNode root, List<Integer> result){
        if (root==null){
            return;
        }
        result.add(root.val);
        builder(root.left, result);
        builder(root.right, result);
    }
}