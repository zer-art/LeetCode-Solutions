class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length ) return -1 ; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>() ; 

        for ( int i =0 ; i < k ; i++){
            maxHeap.add(nums[i]) ; 
        }

        for ( int i = k ; i < nums.length ; i++){ 
            if(maxHeap.peek() < nums[i]){ 
                maxHeap.poll() ; 
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.poll() ; 
    }
}
