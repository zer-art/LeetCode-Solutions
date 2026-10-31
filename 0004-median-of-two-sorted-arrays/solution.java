class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always run binary search on the smaller array to prevent out-of-bounds errors.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1; 
        
        // This gives the exact number of elements needed in the left half, 
        // working correctly for both odd and even total lengths.
        int leftHalfLen = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int cut1 = low + (high - low) / 2; // Elements taken from nums1
            int cut2 = leftHalfLen - cut1;     // Elements taken from nums2

            // Use MIN_VALUE and MAX_VALUE for the edges where an array contributes 0 elements
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if we found the valid partition
            if (l1 <= r2 && l2 <= r1) {
                // If total length is even, median is average of left-max and right-min
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } 
                // If total length is odd, median is simply the max of the left side
                else {
                    return Math.max(l1, l2);
                }
            } 
            // We took too many elements from nums1, move the partition left
            else if (l1 > r2) {
                high = cut1 - 1;
            } 
            // We took too few elements from nums1, move the partition right
            else {
                low = cut1 + 1;
            }
        }
        
        return 0.0; // Fallback, though standard inputs will always return inside the loop
    }
}
