class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        // 1. The Blueprint Map: What words do we need, and how many?
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalWords = words.length;

        // 2. Run 'wordLen' completely independent lanes
        for (int i = 0; i < wordLen; i++) {
            int left = i;  // Back of the window
            int right = i; // Front of the window
            int count = 0; // How many valid words we currently have
            
            // The Temporary Map for this specific lane
            Map<String, Integer> seen = new HashMap<>();

            // 3. Expand the window to the right
            while (right + wordLen <= s.length()) {
                // Grab the next word
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                // Scenario A: We found a word we care about
                if (wordCount.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    // Scenario B: We found an EXCESS word (e.g., a second "foo")
                    // Keep shrinking from the left until the excess word is kicked out
                    while (seen.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen; // Shrink the window
                    }

                    // Scenario C: Perfect Match! We collected all required words.
                    if (count == totalWords) {
                        res.add(left);
                        
                        // Slide the window forward by one word to keep looking for overlaps
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } 
                // Scenario D: Invalid word. The streak is broken.
                else {
                    seen.clear(); // Empty our temporary map
                    count = 0;    // Reset our valid word count
                    left = right; // Snap the left pointer up to where the right pointer is
                }
            }
        }

        return res;
    }
}