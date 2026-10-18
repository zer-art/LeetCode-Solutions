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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> st = new ArrayDeque<>() ; 
        ListNode temp = head ; 
        int i = 0 ; 
        while (temp != null ){ 
            while (!st.isEmpty() && temp.val > st.peek().val ){ 
                st.pop() ; 
            }
            st.push(temp) ; 
            temp = temp.next ; 
        }

        head = st.pop() ;

        while (!st.isEmpty()){ 
            ListNode node = head ; 
            head = st.pop() ; 
            head.next = node ; 
        }

        return head ; 
    }
}
