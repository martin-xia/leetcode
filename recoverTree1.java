/*
 * Leetcode 99: Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Method with O(n) space
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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        //get the inorder traveral of tree
        builder(root, list);
        
        if(list.size()<2) {
            return;
        }
        
        TreeNode first = null;
        TreeNode second = null;
        
        //find two nodes with wrong order
        TreeNode pre = list.get(0);
        for(int i=1; i<list.size(); i++) {
            TreeNode cur = list.get(i);
            if(cur.val<pre.val) {
                if (first == null) {
                    first = pre;
                }
                second = cur;
            }
            pre = cur;
        }
        
        //swap two nodes back
        swap(first,second);
        return;
    }
    
    private void swap(TreeNode first, TreeNode second) {
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp; 
        }
        return;
    }
    
    private void builder(TreeNode root, List<TreeNode> result) {
        if (root==null){
            return;
        }
        
        builder(root.left, result);
        result.add(root);
        builder(root.right, result);
        
    }
}