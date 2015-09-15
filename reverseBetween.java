/*
 * Leetcode 92: Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Martin.Xia
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;
        for(int i = 1; i < m; i++)
            p = p.next;
        
        p.next = reverse(p.next, n - m + 1);
        return helper.next; 
    }
    
    private ListNode reverse(ListNode head, int n){
        ListNode node = head, prev = null, next = null;
        for(int i = 0; i < n; i++){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = node;
        return prev;
    }
}