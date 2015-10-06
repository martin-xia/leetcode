/*
 * Leetcode 25: Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head ==null || k==1){
            return head;
        }
        
        ListNode dummy =new ListNode (0);
        dummy.next=head;
        
        ListNode pre=dummy;
        ListNode cur=head;
        
        int i=0;
        while (cur!=null){
            i++;
            
            if (i%k==0){
                pre=reverse(pre,cur.next);
                cur=pre.next;
            }
            else {
                cur=cur.next;
            }
        }
        return dummy.next;
        
    }

    public ListNode reverse(ListNode pre, ListNode next){
        
        ListNode last=pre.next;
        ListNode cur=last.next;
        
        while (cur!=next){
            
            last.next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            
            cur=last.next;
        }
        return last;
    }
}