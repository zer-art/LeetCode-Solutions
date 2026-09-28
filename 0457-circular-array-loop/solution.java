class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // A value of 0 means we've already visited this index and it didn't lead to a valid cycle
            if (nums[i] == 0) continue; 
            
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            
            while (true) {
                slow = getNextIndex(nums, isForward, slow);
                fast = getNextIndex(nums, isForward, fast);
                if (fast != -1) {
                    fast = getNextIndex(nums, isForward, fast);
                }
                
                // Break if we hit an invalid step (direction changed or cycle length is 1)
                if (slow == -1 || fast == -1) {
                    break;
                }
                
                // Fast caught up to slow; a cycle exists!
                if (slow == fast) {
                    return true;
                }
            }
            
            // If the while loop breaks, this path doesn't have a cycle.
            // Mark all elements in this failed path as 0 so we don't re-evaluate them.
            int curr = i;
            int val = nums[i];
            while (nums[curr] * val > 0) {
                int next = getNextIndex(nums, isForward, curr);
                nums[curr] = 0;
                curr = next;
                if (curr == -1) break;
            }
        }
        
        return false;
    }
    
    private int getNextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean currentDirection = nums[currentIndex] > 0;
        
        // Ensure the path strictly maintains its initial direction
        if (currentDirection != isForward) {
            return -1; 
        }
        
        int n = nums.length;
        
        // The safest modulo formula in Java to handle wrapping negative numbers properly
        int nextIndex = ((currentIndex + nums[currentIndex]) % n + n) % n;
        
        // Ensure the cycle length is strictly greater than 1
        if (nextIndex == currentIndex) {
            return -1; 
        }
        
        return nextIndex;
    }
}
