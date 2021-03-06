/*
 * Leetcode 138: Copy List with Random Pointer 
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Method using hashmap
 * Martin.Xia
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
     
        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);
     
        p = p.next;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }
     
        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null)
                q.random = map.get(p.random);
            else
                q.random = null;
     
            p = p.next;
            q = q.next;
        }
     
        return newHead;
    }
}






