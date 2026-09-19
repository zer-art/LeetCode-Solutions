class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the initial left boundary
        int left = 0;
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        
        // If the array is perfectly sorted, left reaches the end
        if (left == n - 1) {
            return 0;
        }
        
        // Step 2: Find the initial right boundary
        int right = n - 1;
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        
        // Step 3: Find the true min and max inside the unsorted chunk
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        // Step 4: Expand the boundaries outwards based on min and max
        while (left > 0 && nums[left - 1] > minVal) {
            left--;
        }
        while (right < n - 1 && nums[right + 1] < maxVal) {
            right++;
        }
        
        return right - left + 1;
    }
}
