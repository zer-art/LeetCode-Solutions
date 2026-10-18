import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) { 
            return "0";
        }
        
        Deque<Character> st = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            // If the current digit is smaller than the stack's top, pop it (if we still have k removals left)
            while (!st.isEmpty() && k > 0 && (st.peek() - '0') > (c - '0')) {
                st.pop();
                k--; 
            }
            st.push(c); 
        }

        // If k > 0 still (e.g., input was "12345"), pop the remaining k digits from the top
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){ 
            sb.append(st.pop()); 
        }
        
        sb.reverse();
        String result = sb.toString(); 
        
        // Remove leading zeros safely
        int i = 0; 
        while (i < result.length() && result.charAt(i) == '0') { 
            i++; 
        }
        
        result = result.substring(i); 
        
        return result.isEmpty() ? "0" : result; 
    }
}
