/*
 * Leetcode 23: Merge k Sorted Lists
 * Method 2: Merge sort 
 * https://leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        return mergeSort(lists,0,lists.length-1);
    }
    private ListNode mergeSort(ListNode[] lists, int l, int r) {
        if(l<r) {
            int m = (l+r)/2;
            return merge(mergeSort(lists,l,m),mergeSort(lists,m+1,r));
        }
        return lists[l];
    }
    private ListNode merge(ListNode l1, ListNode l2) { 
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                l1 = l1.next;
            }
            else {
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if(l2!=null)
            cur.next = l2;
        return dummy.next;
    }
}