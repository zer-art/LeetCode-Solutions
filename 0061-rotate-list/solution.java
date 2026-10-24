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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head; 

        int len = 1;
        ListNode ptr = head; 

        while (ptr.next != null) { 
            ptr = ptr.next; 
            len += 1; 
        }

        k = k % len;
        if (k == 0) return head; 
        
        int toMove = len - k; 

        ListNode curr = head; 
        for (int i = 1; i < toMove; i++) { 
            curr = curr.next; 
        }

        ListNode newHead = curr.next; 
        ptr.next = head; 
        curr.next = null; 
        head = newHead; 

        return head; 
    }
}
