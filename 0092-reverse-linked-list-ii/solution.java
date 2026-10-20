class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: empty list or no reversal needed
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to handle edge cases like left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 'prev' will eventually point to the node right before 'left'
        ListNode prev = dummy;
        
        // Move prev to the node just before the reversal starts
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // 'curr' points to the first node to be reversed
        ListNode curr = prev.next;
        
        // Reverse the sublist by moving nodes to the front of the sublist
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        
        return dummy.next;
    }
}
