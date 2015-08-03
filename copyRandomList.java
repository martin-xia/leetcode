/*
 * Leetcode 138: Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
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
    public static RandomListNode copyRandomList(RandomListNode head) {  
        if(head == null){  
            return null;  
        }  
          
        RandomListNode cur = head;  
        RandomListNode copyHead = null;  
        RandomListNode copyCur = null;  
          
        while(cur != null){  
            copyCur = new RandomListNode(cur.label);  
            if(copyHead == null){  
                copyHead = copyCur;  
            }  
            copyCur.next = cur.next;  
            cur.next = copyCur;  
            cur = cur.next.next;  
        }  
          
        cur = head;  
        while(cur != null){  
            cur.next.random = cur.random!=null ? cur.random.next : null;          
            cur = cur.next.next;  
        }  
          
        cur = head;  
        while(cur != null){  
            copyCur = cur.next;  
            cur.next = cur.next.next;             
            copyCur.next = cur.next!=null ? cur.next.next : null;         
            cur = cur.next;  
        }  
          
        return copyHead;  
    }  
}






