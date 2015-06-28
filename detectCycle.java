/*
 * Leetcode 142: Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Martin.Xia
 */
 public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow){
                ListNode a1 = head;
                while(slow!=a1){
                    slow=slow.next;
                    a1=a1.next;
                }
                return a1;
                
            }
        }
        return null;
    }
}



