class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (high = 0; high < nums.length; high++) {
            if (nums[high] == 0) {
                k--;
            }

            // If invalid, shift the left bound by at most 1 step instead of shrinking
            if (k < 0) {
                if (nums[low] == 0) {
                    k++;
                }
                low++;
            }
        }

        // The window size (high - low) represents the maximum valid window achieved
        return high - low;
    }
}
