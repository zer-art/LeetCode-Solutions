class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 1. Frequency array bounded to standard ASCII
        int[] counts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }

        char[] sArr = s.toCharArray();
        int remainingNeeded = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int low = 0;

        // 2. Sliding window traversal
        for (int high = 0; high < sArr.length; high++) {
            char rightChar = sArr[high];

            // If rightChar is still desired by t, decrement remaining requirement
            if (counts[rightChar] > 0) {
                remainingNeeded--;
            }
            // Track character in window (can become negative for surplus characters)
            counts[rightChar]--;

            // 3. Shrink window as long as all characters from t are satisfied
            while (remainingNeeded == 0) {
                int currentLen = high - low + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = low;
                }

                char leftChar = sArr[low];
                counts[leftChar]++;
                // If removing leftChar leaves the window deficient, increase requirement
                if (counts[leftChar] > 0) {
                    remainingNeeded++;
                }
                low++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
