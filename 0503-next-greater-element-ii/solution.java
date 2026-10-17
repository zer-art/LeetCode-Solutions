class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize result array with -1
        // If an element never finds a greater element, it remains -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        
        // The stack will store the INDICES of the elements, not the values.
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Loop 2 * n times to simulate a circular array
        for (int i = 0; i < 2 * n; i++) {
            // Use modulo operator to wrap around the index
            int currentIndex = i % n;
            
            // While stack is not empty AND the current element is strictly greater 
            // than the element at the index stored at the top of the stack
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                // We found the next greater element for the index at the top of the stack!
                int prevIndex = stack.pop();
                result[prevIndex] = nums[currentIndex];
            }
            
            // Only push indices during the first pass (i < n)
            // No need to push during the second pass, we just use it to resolve remaining items
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        
        return result;
    }
}
