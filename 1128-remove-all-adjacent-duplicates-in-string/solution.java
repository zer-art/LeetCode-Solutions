class Solution {
    public String removeDuplicates(String s) {
        // Create an array to act as our stack
        char[] stack = new char[s.length()];
        int top = 0; // Points to where the next character should go
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the stack isn't empty and the top item matches, "pop" by moving the pointer back
            if (top > 0 && stack[top - 1] == c) {
                top--; 
            } else {
                // Otherwise, "push" by assigning the character and moving the pointer forward
                stack[top++] = c; 
            }
        }
        
        // Convert only the valid portion of the array back to a String
        return new String(stack, 0, top);
    }
}
