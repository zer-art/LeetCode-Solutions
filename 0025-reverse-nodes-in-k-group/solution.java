class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        // 1. Check if there are at least k nodes remaining in the list
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // 2. If we have exactly k nodes, we reverse them
        if (count == k) {
            curr = head;
            ListNode prev = null;
            
            // Standard linked list reversal for exactly k nodes
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            // 3. After reversing k nodes:
            // - 'prev' is the new head of this reversed group.
            // - 'head' is now the tail of this reversed group.
            // - 'curr' is the pointer to the next unreversed node.
            // We recursively call the function for the remaining list and link it.
            head.next = reverseKGroup(curr, k);
            
            // Return the new head of this reversed part
            return prev;
        }
        
        // 4. If we have less than k nodes left, just return the head (no reversal)
        return head;
    }
}
