class Solution {
    public int findMin(int[] nums) {
        int low = 0; 
        int high = nums.length - 1; // Fixed the syntax error here
        
        // Changed to '<' to prevent the infinite loop when low and high meet
        while (low < high) { 
            int mid = low + (high - low) / 2;
            
            if (nums[mid] > nums[high]) { 
                // The unsorted drop-off is to the right
                low = mid + 1; 
            } else { 
                // The right side is sorted. The minimum is at mid or to its left.
                // We don't use mid - 1 because mid itself could be the minimum!
                high = mid; 
            }
        }

        // When the loop breaks, low == high, pointing exactly at the minimum element.
        return nums[low];   
    }
}
