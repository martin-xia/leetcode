/*
 * Leetcode 144: Binary Tree Preorder Traversal
 * Morris Algorithm
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
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null)
        {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==null) {
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}