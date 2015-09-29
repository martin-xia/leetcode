/*
 * Leetcode 144: Binary Tree Preorder Traversal
 * Iterative method
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
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode q = root;
        while(q!=null || !stack.isEmpty()) {
            if(q!=null) {
                stack.push(q);
                res.add(q.val);
                q = q.left;
            }
            else {
                q = stack.pop();
                q = q.right;
            }
        }
        return res;
    }
}