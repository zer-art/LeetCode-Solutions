class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1; 
        int j = t.length() - 1; 

        int countS = 0;
        int countT = 0;

        while (i >= 0 || j >= 0) { 
            
            // 1. Resolve backspaces for S to find the actual character
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    countS++;
                    i--;
                } else if (countS > 0) {
                    countS--; // Use a backspace to delete this normal character
                    i--;
                } else {
                    break; // We found a valid character, stop moving i
                }
            }
            
            // 2. Resolve backspaces for T to find the actual character
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    countT++;
                    j--;
                } else if (countT > 0) {
                    countT--; 
                    j--;
                } else {
                    break; // We found a valid character, stop moving j
                }
            }
            
            // 3. Compare the characters
            // If both are valid indices, compare the characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } 
            // If one string finished but the other still has valid characters left
            else if (i >= 0 || j >= 0) {
                return false;
            }
            
            // Move to the next characters for the next loop iteration
            i--;
            j--;
        }

        return true; 
    }
}