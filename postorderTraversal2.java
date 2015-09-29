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
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode peekNode = stack.peek();
                if(peekNode.right!=null && pre != peekNode.right) {
                    root = peekNode.right;
                }
                else {
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        return res;
    }
}