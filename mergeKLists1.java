/*
 * Leetcode 23: Merge k Sorted Lists
 * Method 1: use heap
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
        if (lists.length == 0)
            return null;
 
        //PriorityQueue is a heap that use heap-sort
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        return a.val-b.val;
                    }
                });
 
        //add first node of each list to the heap
        for (ListNode list : lists) {
            if (list != null)
                heap.add(list);
        }
 
        ListNode head = new ListNode(0);
        ListNode p = head; // serve as a helper dummy node
 
        while (heap.size() > 0) {
            ListNode temp = heap.poll();
            //poll() retrieves and removes the head of the heap
            p.next = temp;
 
            //keep adding next element of each list
            if (temp.next != null)
                heap.add(temp.next);
 
            p = p.next;
        }
 
        return head.next;
    }
}