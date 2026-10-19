class Solution {
    public int longestPalindrome(String s) {
        int p = 0; 
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Step 1: Count character frequencies
        char[] ch = s.toCharArray();
        for (char c : ch) { 
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }

        // Step 2: Create the iterator AFTER the map is filled
        Iterator<Integer> valueIterator = map.values().iterator();

        boolean hasOdd = false; // To track if we can put a single character in the center

        while (valueIterator.hasNext()) {
            Integer value = valueIterator.next();
            
            // Add the even pairs to our palindrome length
            p += (value / 2) * 2; 
            
            // If the count is odd, we note that we have an odd character available for the center
            if (value % 2 != 0) {
                hasOdd = true;
            }
        }

        // Step 3: If we have any odd-count character left over, we can place one in the center
        if (hasOdd) {
            p += 1;
        }

        return p; 
    }
}
