/*
 * Leetcode 145: Binary Tree Postorder Traversal
 * Iterative method
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
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            //cur node is leaf node
            if(cur.left==null && cur.right==null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }
            //cur node has child node, drill down 
            else {
                if(cur.right!=null) {
                    stack.push(cur.right);
                    //mark cur.right as visited
                    cur.right = null;
                }
                if(cur.left!=null) {
                    stack.push(cur.left);
                    //mark cur.left as visited
                    cur.left = null;
                }
            }
        }
        return res;
    }
}