/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseLinkedList( ListNode prev , ListNode curr){ 
        while(curr != null ){ 
            ListNode nxt = curr.next ; 
            curr.next = prev  ; 
            prev = curr ; 
            curr = nxt ; 
        }   
        return prev ; 
    }
    public void reorderList(ListNode head) {
        // edge cases 
        if(head == null || head.next == null || head.next.next == null ){ 
            return ; 
        }

        // find mid 
        ListNode fast = head ; 
        ListNode slow = head ; 

        while ( fast != null && fast.next != null ){ 
            fast = fast.next.next ; 
            slow = slow.next ; 
        }
        
        ListNode mid = slow.next ; 
        slow.next = null ; 
        

        ListNode first = head ; 
        ListNode second = reverseLinkedList(null , mid);
        
        while (second != null ){ 
            ListNode temp = first.next ; 
            ListNode newSec = second.next ; 
            first.next = second ; 
            second.next = temp ; 
            second = newSec ; 
            first = first.next.next ; 
        }
    
    }
}