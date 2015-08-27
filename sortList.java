/*
 * Leetcode 148: Sort List
 * https://leetcode.com/problems/sort-list/
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        // find middle of list
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
        }
        //break original list into two
        ListNode head2 = walker.next;
        walker.next = null;
        ListNode head1 = head;
        //recursive call
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode helper = new ListNode(0);
        helper.next = head1;
        ListNode pre = helper;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                head1 = head1.next;
            }
            else{
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        // head1 is null, append head2 to the end of the list
        if(head2!=null)
        {
            pre.next = head2;
        }
        // if head2 is null and head1 is not, that means sorting is over,
        // need not to do anything
        return helper.next;
    }
}







