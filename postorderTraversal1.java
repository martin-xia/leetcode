/*
 * Leetcode 145: Binary Tree Postorder Traversal
 * Recursive method
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
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
        
        builder(root.left, result);
        builder(root.right, result);
        result.add(root.val);
    }
}