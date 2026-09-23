class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // 1. Add right character and update historical maxCount
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            
            // 2. If window is invalid, SLIDE it instead of shrinking it
            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            // 3. Update maxLength (the window size only grows or stays the same)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}