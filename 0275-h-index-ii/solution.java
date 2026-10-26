class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Number of papers from 'mid' to the end of the array
            int papersCount = n - mid; 

            if (citations[mid] == papersCount) {
                // Exact match found, this is the maximum possible h-index
                return papersCount; 
            } else if (citations[mid] > papersCount) {
                // Valid h-index, but we might be able to find a larger one 
                // by including more papers (moving left)
                high = mid - 1;
            } else {
                // Citations are too low, need to check papers with more citations (moving right)
                low = mid + 1;
            }
        }
        
        // 'low' will end up at the first valid index, so the number of papers is n - low
        return n - low; 
    }
}
