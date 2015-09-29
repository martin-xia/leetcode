/*
 * Leetcode 145: Binary Tree Postorder Traversal
 * Morris Algorithm
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
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode cur = dummy;
        TreeNode pre = null;
        while(cur!=null) {
            if (cur.left==null) {
                cur = cur.right;
            }
            else {
                pre = cur.left;
                while (pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if (pre.right==null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    reverse(cur.left, pre);
                    TreeNode temp = pre;
                    while (temp != cur.left) {
                        res.add(temp.val);
                        temp = temp.right;
                    }
                    res.add(temp.val);
                    reverse(pre, cur.left);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        } 
        return res;
    }
    private void reverse(TreeNode start, TreeNode end) {
        if (start == end)
            return;
        TreeNode pre = start;
        TreeNode cur = start.right;
        TreeNode next;
        while (pre != end) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }
}