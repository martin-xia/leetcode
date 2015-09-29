/*
 * Leetcode 94: Binary Tree Inorder Traversal
 * Iterative method
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
 
        if(root == null)
            return res; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;
        while(!stack.empty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                res.add(t.val);
                p = t.right;
            }
        }
 
        return res;
    }
}