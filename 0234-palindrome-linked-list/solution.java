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
    private ListNode reverseNodes(ListNode prev, ListNode curr) { 
        while (curr != null) { 
            ListNode nxt = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = nxt; 
        }
        return prev; 
    }

    public boolean isPalindrome(ListNode head) {
        // 1. Simplified base case (handles 0, 1, or 2 nodes automatically below)
        if (head == null || head.next == null) return true; 

        ListNode fast = head; 
        ListNode slow = head; 

        // 2. Find the middle correctly
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
        }

        // If 'fast' is not null, the list length is odd. 
        // We advance 'slow' once to ignore the middle node during comparison.
        if (fast != null) {
            slow = slow.next;
        }

        // 3. Reverse the second half
        ListNode secondHalf = reverseNodes(null, slow);
        ListNode firstHalf = head; 

        // 4. Compare both halves safely
        while (secondHalf != null) { 
            if (firstHalf.val != secondHalf.val) { 
                return false;
            }
            firstHalf = firstHalf.next; 
            secondHalf = secondHalf.next; 
        }

        return true; 
    }
}
