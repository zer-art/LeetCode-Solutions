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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0) ; 
        ListNode prevNode = dummy ; 
        ListNode curr = head ; 
        dummy.next  = curr ;    
        int expectedLen = 1 ; 

        while ( curr != null){ 
            int actualLen = 0 ; 
            ListNode pointer = curr ; 

            while( actualLen < expectedLen && pointer != null ){ 
                actualLen ++ ; 
                pointer= pointer.next ; 
            }

            if ( actualLen %2 == 0 ){ 
                ListNode prev = null ; 
                ListNode nextHead = pointer; 
                for ( int i  = 0  ; i < actualLen ; i++) { 
                    ListNode temp = curr.next ; 
                    curr.next = prev ; 
                    prev = curr ; 
                    curr = temp  ; 
                }

                ListNode currHead = prevNode.next ; 
                prevNode.next  = prev ;
                currHead.next = nextHead ; 
                prevNode = currHead; 
                curr = nextHead ; 

            }else { 
                for ( int i  = 0  ; i < actualLen ; i++) { 
                    curr = curr.next ; 
                    prevNode = prevNode.next ; 
                }
            }
            expectedLen++;
        }

        return dummy.next ; 
    }
}
